package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Course;
import com.example.demo.models.Student;
import com.example.demo.service.CourseService;

@RestController
@RequestMapping("/api/v1/course")
public class CourseController {

	
	@Autowired
	private CourseService courseService;

	
	@GetMapping
	@RequestMapping("id/{id}")
	public Course get(@PathVariable Long id) {
		return courseService.getCourse(id);

	}

	
	@GetMapping
	public List<Course> list() {
		return courseService.getCourseList();

	}
	
//	@GetMapping
//	@RequestMapping("Department/{courseSubject}")
//	public List<Course> getBYDepartment(@PathVariable String courseSubject) {
//		return courseService.getBycourseSubject(courseSubject);
//
//	}
//	
	

}
