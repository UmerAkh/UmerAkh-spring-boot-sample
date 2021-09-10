package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity (name="professor")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})  // Handle error when getting from ID
public class Professor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long professor_id;
	private String professor_name;
	private String professor_hire_date;
	private String professor_salary;
	
	
	
	public Long getProfessor_id() {
		return professor_id;
	}
	public void setProfessor_id(Long professor_id) {
		this.professor_id = professor_id;
	}
	public String getProfessor_name() {
		return professor_name;
	}
	public void setProfessor_name(String professor_name) {
		this.professor_name = professor_name;
	}
	public String getProfessor_hire_date() {
		return professor_hire_date;
	}
	public void setProfessor_hire_date(String professor_hire_date) {
		this.professor_hire_date = professor_hire_date;
	}
	public String getProfessor_salary() {
		return professor_salary;
	}
	public void setProfessor_salary(String professor_salary) {
		this.professor_salary = professor_salary;
	}
	
	

	
}
