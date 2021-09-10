package com.example.demo.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	List<Student> findByFirstNameContains(String firstName);

	// JPQL - Similar to hibernate query language
	// native query

	// JPQL

	@Query(value = "SELECT u FROM student u")
	List<Student> getStudents();

//	@Modifying
//	@Query (value="update student set last_name= :lastName where first_name= :firstName", nativeQuery=true)
//	void updateStudentByFirstName(String firstName, String lastName);

	@Query(value = "SELECT u FROM student u WHERE u.studentEmail = ?1")
	Student findByEmailAddress(String studentEmail);

	@Query(value = "SELECT u FROM student u WHERE u.gender = :gender")
	List<Student> getStudentByGender(@Param("gender") String gender);

//	@Modifying
//	@Query(value = "update student u set u.studentEmail = ?1 where u.studentUsername = ?2", 
//	  nativeQuery = true)
//	void updateUserSetEmailForUserNameNative(String studentEmail, String studentUsername);
//	

	// UPDATE Student email by StudentID
	@Transactional
	@Modifying
	@Query(value = "update Student u set u.student_email = ?1 WHERE u.student_id = ?2", nativeQuery = true)
	void updateUserEmailByUserID(String studentEmail, Long studentId);

	// Insert Student Object
//	@Transactional
//	@PersistenceContext
//	@Modifying
//	@Query(
//	  value = 
//	    "insert into Student (student_username, first_name, last_name) values (:studentUsername, :firsName, :lastName)",
//	  nativeQuery = true)
//	void insertStudent(@Param("studentUsername") String studentUsername, @Param("firstName") String firstName, 
//	  @Param("lastName") String lastName);

	@Transactional
	@Modifying
	@Query(value = "insert into Student (student_username,first_name,last_name,gender) VALUES (:studentUsername,:firstName,:lastName,:gender)", nativeQuery = true)

	void insertStudent(@Param("studentUsername") String studentUsername, @Param("firstName") String firstName,
			@Param("lastName") String lastName, @Param("gender") String gender);

//	@Transactional
//	void updateEmployeeName( Long id, String firstName, String lastName ) ;

	// Deleting from ID
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM Student s WHERE s.student_id=:studentId", nativeQuery = true)
	void deleteStudent(@Param("studentId") Long studentId);

//	EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mysql.jdbc.Driver");
//	EntityManager em = emf.createEntityManager();

//	@PersistenceContext
//	private EntityManager manager;
//	
//	 public void updateEmployeeName( Long id, String firstName, String lastName ) 
//	    {
//	        try
//	        {
//	            manager.createNamedQuery("updateEmployeeName", Student.class)
//	            .setParameter(1, firstName)
//	            .setParameter(2, lastName)
//	            .setParameter(3, id)
//	            .executeUpdate();
//	             
//	            System.out.println("co");
//	        }
//	        catch (Exception e)
//	        {
//	            System.out.println("error");
//	        }
//	    }

}
