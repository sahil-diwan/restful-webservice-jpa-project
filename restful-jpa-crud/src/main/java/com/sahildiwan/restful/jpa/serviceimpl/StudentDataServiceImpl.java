package com.sahildiwan.restful.jpa.serviceimpl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sahildiwan.restful.jpa.DAO.StudentDetailsDAO;
import com.sahildiwan.restful.jpa.jpaentity.Student;
import com.sahildiwan.restful.jpa.service.StudentDataService;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service; 


@Service
@Transactional 
public class StudentDataServiceImpl implements StudentDataService{
	
	@Autowired
	StudentDetailsDAO studentDetailsDAO;
	
	@Override
	public ArrayList<Student> getAllStudents() {
		List<Student> studentDetails=new ArrayList<Student>();
		studentDetails = studentDetailsDAO.findAll();
		return (ArrayList<Student>) studentDetails;
	}

	@Override
	public Student getStudentById(Integer studentId) {
		Student studentDetails = studentDetailsDAO.getOne(studentId);
		return studentDetails;
	}

}
