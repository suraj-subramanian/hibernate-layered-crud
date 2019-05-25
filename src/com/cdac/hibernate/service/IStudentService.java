package com.cdac.hibernate.service;

import java.util.List;

import com.cdac.hibernate.exception.StudentException;
import com.cdac.hibernate.model.Student;

public interface IStudentService {

	public Student addStudent(Student student)throws StudentException;
	public Student getStudentById(Integer id)throws StudentException;
	public Student updateStudent(Student student) throws StudentException;
	public Student deleteStudentById(Integer id)throws StudentException;
	public List<Student> listAllStudent()throws StudentException;
	
}
