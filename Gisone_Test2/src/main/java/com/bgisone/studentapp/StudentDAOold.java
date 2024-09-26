package com.bgisone.studentapp;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOold {

private static List<Student> students = new ArrayList<>();
		public Student create(Student student) {
		        students.add(student);
		        return student;
		}
		    public List<Student> readAll() {
		        return students;
		}
		public Student read(int id) {
		return students.stream().filter(s -> s.getId() == id).findFirst().orElse(null);
		    }
		    public Student update(int id, Student student) {
		        Student updatedStudent = null;
		    	for( Student x : students){
		        	if(x.getId() == id) {
		        		//students.set(id, updatedStudent);
		        		x.setAge(student.getAge());
		        		x.setMajor(student.getMajor());
		        		x.setName(student.getName());
		        		updatedStudent = x;
		        		break;
		        	}
		        }
		        	
		        	
		        	//Student updatedStudent = create(student);
		        return updatedStudent;
		}
		public void delete(int id) { 
			students.removeIf(s -> s.getId() == id);
		} 
	
	
}
