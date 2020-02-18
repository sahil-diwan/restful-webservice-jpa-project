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

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getPhone() {
		return phone;
	}

	public void setPhone(double phone) {
		this.phone = phone;
	}

	public Student(Integer studentId, String studentName, String fatherName, String city, double phone) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.fatherName = fatherName;
		this.city = city;
		this.phone = phone;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", fatherName=" + fatherName
				+ ", city=" + city + ", phone=" + phone + "]";
	}
	
	

}
