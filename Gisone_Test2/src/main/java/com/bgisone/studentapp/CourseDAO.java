package com.bgisone.studentapp;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO {

	private static List<Course> courses = new ArrayList<>();

	/**
	 * CREATE methods
	 */

	/**
	 * Creates a new course, courseId cannot be same for this method
	 *
	 * @param course the new course object
	 * @return new course object
	 */

	public Course create(Course course) {
		for (int i = 0; i < courses.size(); i++) {
			if (courses.get(i).getCourseId() == course.getCourseId()) {
				return null;
			}
		}
		courses.add(course);
		return course;
	}

	/**
	 * Creates a course for a new lab section based on existing course details,
	 * duplicating an existing course with new lab section without the need to add
	 * all the same details again
	 *
	 * @param courseId the id of the course
	 * @param semester the semester of the course
	 * @param year     the year of the course
	 * @return string value
	 */

	public String create(int courseId) {
		for (int i = courses.size() - 1; i >= 0; i--) {
			if (courseId != 0 && courses.get(i).getCourseId() == courseId) {

				Course newCourse = new Course();
				newCourse.setCourseId(courseId);
				newCourse.setCourseName(courses.get(i).getCourseName());
				newCourse.setCourseDepartment(courses.get(i).getCourseDepartment());
				newCourse.setYear(courses.get(i).getYear());
				newCourse.setCourseLimit(courses.get(i).getCourseLimit());
				newCourse.setLabSection((char) (courses.get(i).getLabSection() + 1));

				courses.add(newCourse);
				return "Course with id: " + newCourse.getCourseId()
						+ " has been added into the Course Catalog with Lab Section " + newCourse.getLabSection();
			}
		}
		return "Course with id value " + courseId + " does not exist";
	}

	/**
	 * READ methods
	 */

	/**
	 * Read All values in in-memory course catalog list.
	 *
	 * @param no params
	 * @return returns all courses
	 */
	public List<Course> readAll() {
		return courses;
	}

	/**
	 * Read single course
	 *
	 * @param isbn the id of course
	 * @return first course with id value in arraylist
	 */
	public Course read(int courseId) {
		return courses.stream().filter(c -> c.getCourseId() == courseId).findFirst().orElse(null);
	}

	/**
	 * Read all available courses, courses that have not reached maximum capacity of
	 * students
	 *
	 * @param no param
	 * @return returns all available courses
	 */
	public List<Course> readAvailable() {
		List<Course> available = new ArrayList<>();
		for (int i = 0; i < courses.size(); i++) {
			if (courses.get(i).getAvailability() == true) {
				available.add(courses.get(i));
			}
		}
		return available;
	}

	/**
	 * Reads all unavailable courses, courses that have reached maximum capacity
	 *
	 * @param no params
	 * @return returns all unavailable courses / courses that reached their course limit
	 */
	public List<Course> readFull() {
		List<Course> unavailable = new ArrayList<>();
		for (int i = 0; i < courses.size(); i++) {
			if (courses.get(i).getAvailability() == false) {
				unavailable.add(courses.get(i));
			}
		}
		return unavailable;
	}

	/**
	 * UPDATE methods
	 */

	/**
	 * Updates all courses that matches the coourseId, this includes same course
	 * with different lab sections
	 *
	 * @param courseId the courseId of a course
	 * @param course   a new course object from the request json, if the variable is
	 *                 not null, variable used to replace the fields of the existing
	 *                 course in the list
	 * @return returns the updated course
	 */

	public List<Course> update(int courseId, Course course) { 
		List<Course> updatedCourses = new ArrayList<>();

		for (int i = 0; i < courses.size(); i++) {
			if (courses.get(i).getCourseId() == courseId) {
				if (course.getCourseId() != 0) {
					courses.get(i).setCourseId(course.getCourseId());
				}
				if (course.getCourseName() != null) {
					courses.get(i).setCourseName(course.getCourseName());
				}
				if (course.getCourseDepartment() != null) {
					courses.get(i).setCourseDepartment(course.getCourseDepartment());
				}
				if (course.getYear() != 0) {
					courses.get(i).setYear(course.getYear());
				}
				updatedCourses.add(courses.get(i));
			}
		}
		return updatedCourses;
	}

	/**
	 * Enrolls students into first available course based on the name of the course.
	 * Once course reaches limit, course becomes full and is no longer available
	 *
	 * @param courseName Name of the course the student will enrol into
	 * @param student    the student who is enrolling into the course
	 * @return string value
	 */

	public String updateEnroll(int courseId, Student student) {
		for (int i = 0; i < courses.size(); i++) {
			if (student.getId() != 0 && courses.get(i).getCourseId() == courseId
					&& courses.get(i).getAvailability() == true) {
				courses.get(i).getStudentIDList().add(student.getId());
				if (courses.get(i).getCourseLimit() == courses.get(i).getStudentIDList().size()) {
					courses.get(i).setAvailability(false);
				}

				return "Course Id: " + courses.get(i).getCourseId() + ", Course " + courses.get(i).getCourseName()
						+ ", has been enrolled by: " + student.getName();
			} else if (student.getId() == 0) {
				return "Please enter ID of student before enrollment";
			}
		}
		return "Course with Course Id value " + courseId + " does not exist or is unavailable";
	}

	/**
	 * Enrolls multiple students into first available course based on the name of
	 * the course. Once course reaches limit, course becomes full and is no longer
	 * available
	 *
	 * @param courseName Name of the course the student will enrol into
	 * @param student    the student who is enrolling into the course
	 * @return string value
	 */

	public String updateEnrollMultiple(int courseId, List<Integer> studentIds) {
		String enrolled = "";
		for (int i = 0; i < courses.size(); i++) {
			if (courses.get(i).getCourseId() == courseId && courses.get(i).getAvailability() == true) {
				for (int l = 0; l < studentIds.size(); l++) {
					if (courses.get(i).getAvailability() != false) {
						courses.get(i).getStudentIDList().add(studentIds.get(l));
						enrolled = enrolled + studentIds.get(l) + " ";
						studentIds.remove(l);
						
						if (courses.get(i).getCourseLimit() == courses.get(i).getStudentIDList().size()) {
							courses.get(i).setAvailability(false);
						}
					}
				}
			}
		}
		if (enrolled != "") {
			return "Multiple students have been enrolled: " + enrolled;
		} else {
			return "Course with Course Id value " + courseId + " does not exist or is unavailable";
		}
	}

	/**
	 * Drops students from the course
	 *
	 * @param courseId courseId of course that student will be dropping
	 * @param student  the student who is dropping out of the course
	 * @return string value
	 */

	public String updateDrop(int courseId, Student student) {

		for (int i = 0; i < courses.size(); i++) {
			if (student.getId() != 0 && courses.get(i).getCourseId() == courseId) {
				for (int l = 0; l < courses.get(i).getStudentIDList().size(); l++) {
					if (courses.get(i).getStudentIDList().get(l) == student.getId()) {
						courses.get(i).getStudentIDList().remove(l);
						courses.get(i).setAvailability(true);
						return "Course Id: " + courses.get(i).getCourseId() + ", Course " + courses.get(i).getCourseName()
								+ ", dropped by student: " + student.getName();
					}
				}
				return "Student not found in course.";
				
			} else if (student.getId() == 0) {
				return "Please enter ID of student before dropping course";
			}

		}
		return "Course with courseID value " + courseId + " does not exist or not available";
	}

	/**
	 * DELETE methods
	 */
	public void deleteCourse(int courseId) {
		courses.removeIf(b -> b.getCourseId() == courseId);
	}

}
