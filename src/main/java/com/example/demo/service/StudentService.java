package com.example.demo.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.emample.demo.sql.RandomSql;
import com.example.demo.Repository.StudentRepository;
import com.example.demo.models.Student;

@Service
public class StudentService {

	@PersistenceContext
	@Autowired
	private EntityManager mssqlEntityManager;

//	@PersistenceContext
//	 private static EntityManagerFactory entityManagerFactory =
//	          Persistence.createEntityManagerFactory("com.mysql.jdbc.Driver");
//	
	@Autowired
	private StudentRepository studentRepository;

	public Student getStudent(Long id) {
		return studentRepository.getOne(id);
	}

	public List<Student> getStudentList() {
		return studentRepository.findAll();

	}

	public List<Student> getByFirstName(String firstName) {
		return studentRepository.findByFirstNameContains(firstName);

	}

	public Student createStudent(Student student) {

		return studentRepository.saveAndFlush(student);

	}

	public void deleteById(long id) {

		studentRepository.deleteById(id);

	}

	public Student update(long id, Student student) {
		Student existingSession = studentRepository.getOne(id);

		BeanUtils.copyProperties(student, existingSession, "student_id");
		return studentRepository.saveAndFlush(existingSession);

	}

	public List<Student> getAllStudent() {
		return studentRepository.getStudents();
	}

//	public void updateStudent(String firstName, String lastName) {
//		studentRepository.updateStudentByFirstName(firstName, lastName);
//		
//	}

	public Student SearchByEmail(String email) {

		return studentRepository.findByEmailAddress(email);
	}

	public List<Student> SearchByGender(String studentGender) {

		return studentRepository.getStudentByGender(studentGender);

	}

//	public void updateByUserName(String sEmail,String studentUser) {
//
//		 studentRepository.updateUserSetEmailForUserNameNative(sEmail,studentUser);
//
//	}
//	

	public void updateByEmailByUserId(String sEmail, Long studentId) {

		studentRepository.updateUserEmailByUserID(sEmail, studentId);

	}

//	public void addStudent(String userName, String firstName, String lastName) {
//		
//		studentRepository.insertStudent(userName, firstName, lastName);
//		
//	}

	public void addStudent(String a, String b, String c, String d) {
		studentRepository.insertStudent(d, a, a, d);

	}

	public void removeStudent(Long studentID) {
		studentRepository.deleteStudent(studentID);

	}

	 @Transactional
	    public List<Student> GetFreakingStudents(String gender) {
//	        entityManager.persist(user);
		   // EntityManager entityManager=entityManagerFactory.createEntityManager();

		 //   entityManager.getTransaction().begin();
		    Query query = mssqlEntityManager.createNativeQuery(RandomSql.getStudentsFromGender);
		   
		    query.setParameter("gender",   gender);
		    List<Student> resultList = query.getResultList();
		    //		 Query updateApplication= entityManager.createNativeQuery("SELECT u FROM student u WHERE u.gender = :?",Student.class);
	        return resultList;
	    }
	 @Transactional
	 public void RemoveFreakingStudent(Long studentId) {
		 
		 Query query = mssqlEntityManager.createNativeQuery(RandomSql.removeStudent);
		 query.setParameter("studentId",   studentId);
		 query.executeUpdate();	 
	 }
	 
	 @Transactional
	 public void addStudentPlease(String userName, String firstName, String lastName, String gender) {
		 Query query = mssqlEntityManager.createNativeQuery(RandomSql.insertStudent);
		 query.setParameter("studentUsername",   userName);
		 query.setParameter("firstName",   firstName);
		 query.setParameter("lastName",   lastName);
		 query.setParameter("gender",   gender);
		 query.executeUpdate();	 
	 }
	 
	 @Transactional
	 public void correctMyEmailPlease(String email, Long studentId) {
		 Query query = mssqlEntityManager.createNativeQuery(RandomSql.updateStudentEmail);
		 query.setParameter("studentEmail",   email);
		 query.setParameter("studentId",   studentId);
		 query.executeUpdate();	 
	 }
	 
}
