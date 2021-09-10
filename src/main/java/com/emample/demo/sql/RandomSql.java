package com.emample.demo.sql;

public class RandomSql {
	public static String getStudentsFromGender = "SELECT s.first_name, s.last_name FROM student s Where s.gender= :gender";
	public static String removeStudent = "DELETE FROM Student s WHERE s.student_id=:studentId";
	public static String insertStudent = "insert into Student (student_username,first_name,last_name,gender) VALUES (:studentUsername,:firstName,:lastName,:gender)";
	public static final String  updateStudentEmail = "update Student u set u.student_email = :studentEmail WHERE u.student_id = :studentId";

}
