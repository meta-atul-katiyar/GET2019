package com.metacube.demo.dto;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


public class UserDto {

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

	@Pattern(regexp = "(0/91)?[6-9][0-9]{9}", message = "{validContact}")
	@NotNull(message = "{blankContact}")
	private String contactNumber;
	
	@NotBlank(message = "{blankUserName}")
	@Pattern(regexp="^[a-zA-Z0-9]{4,}", message = "{validUserName}")
	 String username;
	boolean enabled = true;

	
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	@NotBlank(message = "{blankPassword}")
	@Pattern(regexp="^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{6,20}$", message = "{validPassword}")
	 String password;

	//Default constructor. 
	public UserDto() {}

	/**
	 * Initialize the value.
	 * @param firstName
	 * @param lastName
	 * @param fatherName
	 * @param email
	 * @param userName
	 * @param password
	 */
	public UserDto(String firstName, String lastName, String fatherName,
			String email, String userName, String password) {
		this.username = username;
		this.email = email;
		this.fatherName = fatherName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
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
	public String getUsername() {
		return username;
	}

	//Set the value of age.
	public void setUsername(String username) {
		this.username = username;
	}

	//Return the student class.
	public String getPassword() {
		return password;
	}
	
	//Set the value of student class..
	public void setPassword(String password) {
		this.password = password;
	}

}