package com.metacube.demo.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class SearchUserDto {

	@NotBlank(message = "{blankUserName}")
	@Pattern(regexp="^[a-zA-Z0-9]{4,}", message = "{validUserName}")
	 String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
