package com.cdac.hibernate.controller;

import java.util.Iterator;
import java.util.List;

import com.cdac.hibernate.exception.StudentException;
import com.cdac.hibernate.model.Student;
import com.cdac.hibernate.service.IStudentService;
import com.cdac.hibernate.service.StudentService;

public class StudentController {
	
	public static void main(String[] args) {
		
		System.out.println("Hibernate Example:");
		
		IStudentService service = new StudentService();
		
		Student s1 = new Student("Jojo",88.0);
		
		try {
			//Delete Student by Id
			//service.deleteStudentById(2);
			
			//Adding new student
			service.addStudent(s1);
			
			//Update Student
			//service.updateStudent(s1);
			
			
			//List all student
			List<Student>students=service.listAllStudent();
			Iterator<Student> it = students.iterator();
			
			while(it.hasNext()) {
				System.out.println(it.next());
			}
			
		} catch (StudentException e) {
			e.printStackTrace();
		}
		
		
	}

}
