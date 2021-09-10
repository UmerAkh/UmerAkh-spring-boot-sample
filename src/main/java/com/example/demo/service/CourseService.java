package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.CourseRepository;
import com.example.demo.models.Course;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;

	public Course getCourse(Long id) {
		return courseRepository.getOne(id);
	}

	public List<Course> getCourseList() {
		return courseRepository.findAll();

	}

		
//	public List<Course> getBycourseSubject(String Department){
//	
//	
//	return courseRepository.findByCourseSubjectContains(Department);
//}
//	
	

}
