package com.metacube.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 *POJO class of student. 
 *Entity of student.
 */
@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;
	@NotBlank(message = "{blankFirstName}")
	 String firstName;

	@NotBlank(message = "{blankLastName}")
	 String lastName;
	

	@NotBlank(message = "{blankFatherName}")
	 String fatherName;

	@Email(message = "{validEmail}")
	@NotBlank(message = "{blankEmail}")
	 String email;

	
	@Pattern(regexp = "[1-12]+", message = "{validStudentClass}")
	@NotBlank(message ="{blankClass}")
	 String studentClass;

	
	@Pattern(regexp = "[0-9]+", message = "{validAge}")
	@NotBlank(message = "{blankAge}")
	 String studentAge;

	//Default constructor. 
	public Student() {}

	/**
	 * Initialize the value.
	 * @param firstName
	 * @param lastName
	 * @param fatherName
	 * @param email
	 * @param studentClass
	 * @param age
	 */
	public Student(String firstName, String lastName, String fatherName,
			String email, String studentClass, String age) {
		this.studentAge = age;
		this.email = email;
		this.fatherName = fatherName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentClass = studentClass;
	}
	
	//Return the first name.
	public String getFirstName() {
		return firstName;
	}

	//Set the value of first name.
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	//Return the last name.
	public String getLastName() {
		return lastName;
	}

	//Set the value of last name.
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	//Return the father name.
	public String getFatherName() {
		return fatherName;
	}

	//Set the value of father name.
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	//Return the email.
	public String getEmail() {
		return email;
	}

	//Set the value of email.
	public void setEmail(String email) {
		this.email = email;
	}

	//Return the age.
	public String getStudentAge() {
		return studentAge;
	}

	//Set the value of age.
	public void setStudentAge(String age) {
		this.studentAge = age;
	}

	//Return the student class.
	public String getStudentClass() {
		return studentClass;
	}
	
	//Set the value of student class..
	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}

}