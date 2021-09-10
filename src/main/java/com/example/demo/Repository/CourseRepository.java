package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

	
//	@Query ("FROM a WHERE a.course_subject = ?1")
//	List<Course> findByCourseSubjectContains(String department);
	
	
	
	
}
