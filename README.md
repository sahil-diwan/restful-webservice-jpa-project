# restful-webservice-jpa-project
Creating a Restful Service with all the required CRUD operations using JPA

Things required to create a JPA CRUD Restful Webservice.
	1.Create Config file.
	2.Add Properties file and specific dependencies in the pom.xml
	3.JPA Entity
	4.DAO Layer Component
	5.Service Layer Interface with the methods.
	6.Service Layer Implementations
	7.Service Controller


1. Create a database studentdb
		create database studentdb;
		use studentdb; 
		
2. Create a table and fill with the following data
		create table studentdetails(
			student_id int primary key,
			student_name char(30),
			father_name char(30),
			city char(30),
			phone double,
			); 

3. Insert data in to the table
	
		insert into studentdetails values(101,'Sahil Diwan','Susheel Diwan','Bangalore',9108290271);
		insert into studentdetails values(102,'Sunil Diwan','Varinder Diwan','Bangalore',8950565647);
		insert into studentdetails values(103,'Himanshu Diwan','Varinder Diwan','Bangalore',8950565647);

4. Update the application.properties with the following details.

	spring.application.name=StudentMS  // Name of the microservice being used.
	server.port=8000				  //  Port on which the microservice is going to run
	spring.datasource.driver-class-name=com.mysql.jdbc.Driver
	spring.datasource.url=jdbc:mysql://localhost:3306/studentdb
	spring.datasource.username=root
	spring.datasource.password=root
	spring.datasource.hikari.connectionTimeout=20000
	spring.datasource.hikari.maximumPoolSize=5
	logging.level.root=INFO
	logging.pattern.console=%-5level %logger{36} - %msg%n
	spring.jpa.show-sql=true
	spring.jpa.hibernate.ddl-auto=update 

		
5. Create a project from start.spring.io
		
			Group 		com.sahildiwan.restful.jpa
			Artifact	restful-jpa-crud
			
			Add Dependencies
				* Spring Web
				* Spring Boot DevTools
				* Spring Data JPA

6. Update the pom.xml with the the data below.

	<?xml version="1.0" encoding="UTF-8"?>
	<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.2.4.RELEASE</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	<groupId>com.sahildiwan.restful.jpa</groupId>
	<artifactId>restful-jpa-crud</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>restful-jpa-crud</name>
	<description>Demo project for Spring Boot</description>

	<properties>
		<java.version>1.8</java.version>
	</properties>

	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
			<exclusions>
				<exclusion>
					<groupId>org.junit.vintage</groupId>
					<artifactId>junit-vintage-engine</artifactId>
				</exclusion>
			</exclusions>
		</dependency>
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>

	</project>



7. Create a package config and add the files as below.
		
		File Name : StudentConfig
		
		package com.sahildiwan.restful.jpa.restfuljpacrud.config;

		import org.springframework.boot.autoconfigure.SpringBootApplication;
		import org.springframework.transaction.annotation.EnableTransactionManagement;
		import org.springframework.web.servlet.config.annotation.EnableWebMvc;
		import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


		@EnableWebMvc
		@EnableTransactionManagement
		@SpringBootApplication(scanBasePackages = { "com.sahildiwan.restful.jpa.restfuljpacrud" })
		public class StudentConfig  implements WebMvcConfigurer{
		}

8. Make changes to add loggers to the RestfulJpaCrudApplication which is the main file.

			package com.sahildiwan.restful.jpa;

			import org.springframework.boot.SpringApplication;
			import org.springframework.boot.autoconfigure.SpringBootApplication;
			import org.slf4j.Logger;
			import org.slf4j.LoggerFactory;
			import org.springframework.boot.CommandLineRunner;


			@SpringBootApplication
			public class RestfulJpaCrudApplication implements CommandLineRunner { 
				
				static Logger log=LoggerFactory.getLogger(RestfulJpaCrudApplication.class);
				
				public void run(String... args) throws Exception {
					//Start-UP Tasks
					 log.info("MS - Launched.... ");
					} 

				
				public static void main(String[] args) {
					log.info("MS - Begin "); 
					SpringApplication.run(RestfulJpaCrudApplication.class, args);
					log.info("MS - End "); 
				}


			}


9. Write the JPA Entity
	
	package com.sahildiwan.restful.jpa.jpaentity;

	
	import javax.persistence.*;
	import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
	@Entity
	@Table(name="studentdetails",schema = "studentdb")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bookId_generator")
	@SequenceGenerator(name="bookId_generator",sequenceName =
	"mybookId_gen",initialValue = 110,allocationSize =1)
	@Column(name="student_id")
	private Integer studentId; 
	
	@Column(name="student_name") 
	private String studentName;
	
	@Column(name="father_name") 
	private String fatherName;
	
	@Column(name="city") 
	private String city;
	
	@Column(name="phone") 
	private double phone;
	
	//Getter Setter 
	//Constructor

	}

10. Write the DAO layer interface

	package com.sahildiwan.restful.jpa.DAO;

	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.stereotype.Repository;

	import com.sahildiwan.restful.jpa.jpaentity.Student; 

	@Repository
	public interface StudentDetailsDAO  extends JpaRepository<Student,Integer> {

	}


11. Write Service Layer Interface
	
	package com.sahildiwan.restful.jpa.service;

	import java.util.ArrayList;

	import com.sahildiwan.restful.jpa.jpaentity.Student;

	public interface StudentDataService {

		public ArrayList<Student> getAllStudents();
		public Student getStudentById(Integer studentId); 

	}


12. Write Service Layer Implementations

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



13. Write the Controller Implementation

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
