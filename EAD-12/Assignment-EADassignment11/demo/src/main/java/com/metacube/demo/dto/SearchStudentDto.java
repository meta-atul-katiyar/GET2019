package com.metacube.demo.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SearchStudentDto {

	@Size(min = 3, max = 30)
	@NotBlank(message = "{name}")
	@NotNull
	String firstName;
	
	
	public SearchStudentDto(String firstName,String lastName) {
		super();
		this.firstName = firstName;
	}

	public SearchStudentDto() {
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

}
