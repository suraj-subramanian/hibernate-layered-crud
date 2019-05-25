/**
 * 
 */
package com.cdac.hibernate.service;

import java.util.List;

import com.cdac.hibernate.dao.IStudentDao;
import com.cdac.hibernate.dao.StudentDao;
import com.cdac.hibernate.exception.StudentException;
import com.cdac.hibernate.model.Student;

/**
 * @author Suraj
 *
 */
public class StudentService implements IStudentService {

	private IStudentDao studentDao;
	
	public StudentService(){
		studentDao=new StudentDao();
	}

	@Override
	public Student addStudent(Student student) throws StudentException {
		studentDao.beginTransaction();
		Student addedStudent=studentDao.addStudent(student);
		studentDao.commitTransaction();
		return addedStudent;
	}

	@Override
	public Student getStudentById(Integer id) throws StudentException {
		return studentDao.getStudentById(id);
	}

	@Override
	public Student updateStudent(Student student) throws StudentException {
		studentDao.beginTransaction();
		Student updatedStudent=studentDao.updateStudent(student);
		studentDao.commitTransaction();
		return updatedStudent;
	}

	@Override
	public Student deleteStudentById(Integer id) throws StudentException {
		studentDao.beginTransaction();
		Student deletedStudent=studentDao.deleteStudentById(id);
		studentDao.commitTransaction();
		return deletedStudent;
	}

	@Override
	public List<Student> listAllStudent() throws StudentException {
		return studentDao.listAllStudent();
	}
}
