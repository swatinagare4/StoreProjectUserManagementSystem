package com.usermanagement.exception;

public class UserNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;  
	
	String resourcename;
	
	String fieldname;
	
	Integer fieldvalue;

	public String getResourcename() {
		return resourcename;
	}

	public void setResourcename(String resourcename) {
		this.resourcename = resourcename;
	}

	public String getFieldname() {
		return fieldname;
	}

	public void setFieldname(String fieldname) {
		this.fieldname = fieldname;
	}

	public Integer getFieldvalue() {
		return fieldvalue;
	}

	public void setFieldvalue(Integer fieldvalue) {
		this.fieldvalue = fieldvalue;
	}

	public UserNotFoundException(String resourcename, String fieldname, Integer fieldvalue) {
	super(String.format("%s Not Found With %s :%s ",resourcename, fieldname, fieldvalue));
		this.resourcename = resourcename;
		this.fieldname = fieldname;
		this.fieldvalue = fieldvalue;
	}
	
	

}
