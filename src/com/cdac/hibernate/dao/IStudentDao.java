package com.cdac.hibernate.dao;

import java.util.List;

import org.hibernate.Transaction;

import com.cdac.hibernate.exception.StudentException;
import com.cdac.hibernate.model.Student;

public interface IStudentDao {
	
	public Student addStudent(Student student)throws StudentException;
	public Student getStudentById(Integer id)throws StudentException;
	public Student updateStudent(Student student) throws StudentException;
	public Student deleteStudentById(Integer id)throws StudentException;
	public List<Student> listAllStudent()throws StudentException;
	public Transaction beginTransaction()throws StudentException;
	public void commitTransaction()throws StudentException;

}
