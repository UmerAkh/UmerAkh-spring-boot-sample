package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "student")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" }) // Handle error when getting from ID
//@NamedNativeQueries({
//    @NamedNativeQuery(
//            name    =   "updateEmployeeName",
//            query   =   "UPDATE student SET first_name = ?, last_name = ? WHERE student_id = ?"
//            
//    )
//})


public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "student_id")
	private Long studentId;

	@Column(name = "student_username")
	private String studentUsername;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	private String gender;

	@Column(name = "student_dob")
	private String studentDOB;

	@Column(name = "student_email")
	private String studentEmail;

	@Column(name = "enrollment_date")
	private String enrollmentDate;

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getStudentUsername() {
		return studentUsername;
	}

	public void setStudentUsername(String studentUsername) {
		this.studentUsername = studentUsername;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getStudentDOB() {
		return studentDOB;
	}

	public void setStudentDOB(String studentDOB) {
		this.studentDOB = studentDOB;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public String getEnrollmentDate() {
		return enrollmentDate;
	}

	public void setEnrollmentDate(String enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}

}
