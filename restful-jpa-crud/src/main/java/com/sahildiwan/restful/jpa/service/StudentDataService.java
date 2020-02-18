package com.sahildiwan.restful.jpa.service;

import java.util.ArrayList;

import com.sahildiwan.restful.jpa.jpaentity.Student;

public interface StudentDataService {

	public ArrayList<Student> getAllStudents();
	public Student getStudentById(Integer studentId); 

}
