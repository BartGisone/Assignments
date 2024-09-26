package com.bgisone.studentapp;

import java.util.ArrayList;
import java.util.List;

public class Course {
	private int courseId;
	private String courseName;
	private String courseDepartment;
	private int year; 
	
	private char labSection = 'A';
	private boolean available = true;
	private int courseLimit;
	List<Integer> studentIDList = new ArrayList<>();

	// Getters

	public int getCourseId() {
		return courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public String getCourseDepartment() {
		return courseDepartment;
	}
	public int getYear() {
		return year;
	}
	
	public char getLabSection() {
		return labSection;
	}
	
	public boolean getAvailability() {
		return available;
	}

	public int getCourseLimit() {
		return courseLimit;
	}
	
	public List<Integer> getStudentIDList() {
		return studentIDList;
	}

	
	
	// Setters
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public void setCourseDepartment(String courseDepartment) {
		this.courseDepartment = courseDepartment;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	public void setLabSection(char labSection) {
		this.labSection = labSection;
	}
	public void setAvailability(boolean available) {
		this.available = available;
	}
	public void setCourseLimit(int courseLimit) {
		this.courseLimit = courseLimit;
	}
}


