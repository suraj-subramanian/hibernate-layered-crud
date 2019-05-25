package com.cdac.hibernate.dao;

import java.util.List;

//import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.cdac.hibernate.exception.StudentException;
import com.cdac.hibernate.model.Student;

public class StudentDao implements IStudentDao {

	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
//	private Query query;
	
	@SuppressWarnings("deprecation")
	public StudentDao() {
		sessionFactory=new Configuration().configure().buildSessionFactory();
		session=sessionFactory.openSession();
	}
	
	
	@Override
	public Student addStudent(Student student) throws StudentException {
		session.save(student);
		return student;
	}

	@Override
	public Student getStudentById(Integer id) throws StudentException {
		return (Student) session.get(Student.class, id);
	}

	@Override
	public Student updateStudent(Student student) throws StudentException {
		session.update(student);
		return student;
	}

	@Override
	public Student deleteStudentById(Integer id) throws StudentException {
		Student student = getStudentById(id);
		if(student!=null)
			session.delete(student);
		else
			student=null;
		return student;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> listAllStudent() throws StudentException {
		return session.createQuery("from Student").list();
	}

	@Override
	public Transaction beginTransaction() throws StudentException {
		transaction=session.beginTransaction();
		return transaction;
	}

	@Override
	public void commitTransaction() throws StudentException {
		transaction.commit();
	}

}
