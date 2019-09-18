package com.metacube.parkingSystem.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Employee {
	
	@NotBlank(message = "{blankName}")
	@Pattern(regexp="^[a-zA-Z ]{1,}", message = "{validName}")
	private String fullName;
	
	@NotNull(message="select some value")
	private String gender;
	
	@Email(message = "{validEmail}")
	@NotBlank(message = "{blankEmail}")
	private String email;
	
	@NotBlank(message = "{blankPassword}")
	@Pattern(regexp="^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{6,20}$", message = "{validPassword}")
	private String password;
	
//	@NotBlank(message = "{blankConfirmPassword}")
//	private String confirmPassword;
	
	@Pattern(regexp = "(0/91)?[6-9][0-9]{9}", message = "{validContact}")
	@NotNull(message = "{blankContact}")
	private String contactNumber;
	
	@NotNull(message = "blankContact")
	private String organization;
	
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
//	public String getConfirmPassword() {
//		return confirmPassword;
//	}
//	public void setConfirmPassword(String confirmPassword) {
//		this.confirmPassword = confirmPassword;
//	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
}
