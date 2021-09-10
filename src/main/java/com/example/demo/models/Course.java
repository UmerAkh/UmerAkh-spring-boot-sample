package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "course")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" }) // Handle error when getting from ID

public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column (name="course_id")
	private Long courseId;
	
	@Column (name="course_name")
	private String courseName;

	@Column (name="course_detail")
	private String coursDetail;

	@Column (name="course_description")
	private String courseDescription;

	@Column (name="course_subject")
	private String courseSubject;

	
	private String status;
	
	@Column (name="professorId")
	private Long professorId;

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCoursDetail() {
		return coursDetail;
	}

	public void setCoursDetail(String coursDetail) {
		this.coursDetail = coursDetail;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	public String getCourseSubject() {
		return courseSubject;
	}

	public void setCourseSubject(String courseSubject) {
		this.courseSubject = courseSubject;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getProfessorId() {
		return professorId;
	}

	public void setProfessorId(Long professorId) {
		this.professorId = professorId;
	}
	
	
	
	
	
	
}
