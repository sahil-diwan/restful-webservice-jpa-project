package com.sahildiwan.restful.jpa.controller;


import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sahildiwan.restful.jpa.jpaentity.Student;
import com.sahildiwan.restful.jpa.service.StudentDataService;
@CrossOrigin //CORS
@RestController
public class StudentController {
	static Logger log=LoggerFactory.getLogger(StudentController.class);
	@Autowired
	StudentDataService studentDataService; 
	
	@GetMapping()
	public ArrayList<Student> getStudentDetails(){
	log.info("---Student Controller-----");
	ArrayList<Student> studentDetails=studentDataService.getAllStudents();
	return studentDetails;
	} 
	
	
	@GetMapping("{studentId}")
	public Student getStudentDetailsById(@PathVariable Integer studentId){
	log.info("---Student Controller-----");
	Student studentDetails=studentDataService.getStudentById(studentId);
	return studentDetails;
	} 

	

}
