package com.usermanagement.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserDto {
	
	
	@NotEmpty
	@Size(min = 4, max = 10,message = "Username must be min 4 char and max 10 char ")
	private String name;

	@Email
	private String email;

	@NotEmpty
	@Size(min = 4, max = 10,message = "password must be min 4 char and max 10 char ")
	private String password;
	
	
	@NotEmpty
	@Size(min = 4, max = 10,message = "Phone_Number must be min 4 char and max 10 char ")
	private String phoneno;
	
	
	@NotEmpty
	@Size(min = 4, max = 10,message = "Address must be min 4 char and max 10 char ")
	private String address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	

	public UserDto(String name, String email, String password, String phoneno, String address) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.phoneno = phoneno;
		this.address = address;
	}

	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
