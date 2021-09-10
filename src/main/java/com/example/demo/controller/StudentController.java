package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping
	@RequestMapping("{id}")
	public Student get(@PathVariable Long id) {
		return studentService.getStudent(id);

	}

	@GetMapping
	public List<Student> list() {
		return studentService.getStudentList();

	}

	@GetMapping
	@RequestMapping("fn/{firstName}")
	public List<Student> getBYFirstName(@PathVariable String firstName) {
		return studentService.getByFirstName(firstName);

	}

	@GetMapping
	@RequestMapping("email={studentEma}")
	public Student SearchBYEmail(@PathVariable String studentEma) {
		return studentService.SearchByEmail(studentEma);

	}

	@GetMapping
	@RequestMapping("gender={gender}")
	public List<Student> SearchByGender(@PathVariable String gender) {
		return studentService.GetFreakingStudents(gender);

//		return studentService.SearchByGender(gender);

	}

	@PostMapping
	public Student create(@RequestBody final Student student) {
		return studentService.createStudent(student);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE) // Deleting from the database
	public void delete(@PathVariable long id) {

		studentService.deleteById(id);

	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public Student update(@PathVariable Long id, @RequestBody Student student) {

		return studentService.update(id, student);
	}

	@GetMapping
	@RequestMapping("getAll")
	public List<Student> GetStudents() {

		return studentService.getAllStudent();

	}

//	@RequestMapping(value ="S/{studentEmail}/{studentUsername}", method = RequestMethod.PUT)
//	public void UpdateByUserName(String studentEmail,String studentUsername){
//		
//		 studentService.updateByUserName(studentEmail, studentUsername);
//		
//	}

	@RequestMapping(value = "st={studentEmail}/{studentId}", method = RequestMethod.PUT)
	public void UpdateByUserName(@PathVariable String studentEmail, @PathVariable Long studentId) {

		studentService.correctMyEmailPlease(studentEmail, studentId);
		//studentService.updateByEmailByUserId(studentEmail, studentId); // Alternative
	}

//	@RequestMapping(value = "add={studentUsername}/{firstName}/{lastName}", method = RequestMethod.POST)
//	public void addStudents(@PathVariable String studentUsername, @PathVariable String firstName, @PathVariable String lastName ) {
//
//		studentService.addStudent(studentUsername, firstName,lastName);
//System.out.println(studentUsername+ " "+firstName );
//	}

//	@GetMapping
//	@RequestMapping(value= "{firstName}/{lastName}", method = RequestMethod.PUT)
//	public void updateStudent(@PathVariable  String firstName,  @RequestBody String lastName) {
//		studentService.updateStudent(firstName, lastName);
//		
//	}
	@RequestMapping(value = "insertStudent/{username}/{FN}/{LN}/{gender}", method = RequestMethod.POST)
	public void insertAttributes(@PathVariable String username, @PathVariable String FN, @PathVariable String LN,
			@PathVariable String gender) {

		//studentService.addStudent(username, FN, LN, gender);  // Alternate Method
		
		studentService.addStudentPlease(username, FN, LN, gender);
	}

	@RequestMapping(value = "deleteStudent/{studentId}", method = RequestMethod.DELETE)
	public void insertAttributes(@PathVariable Long studentId) {

		// studentService.removeStudent(studentId); Alternative withJPQL
		System.out.println("studentId " + studentId);
		studentService.RemoveFreakingStudent(studentId);
	}

//	@RequestMapping(value = "add={studentid}/{firstName}/{lastName}", method = RequestMethod.PUT)
//	public void addStudents(@PathVariable Long studentid, @PathVariable String firstName, @PathVariable String lastName ) {
//
//		studentService.updateEmployeeName(studentid, firstName,lastName);
//System.out.println(studentid+ " "+firstName );
//	}

}
