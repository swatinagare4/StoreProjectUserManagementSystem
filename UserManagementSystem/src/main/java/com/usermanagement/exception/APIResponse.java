package com.usermanagement.exception;

public class APIResponse {
	
	private String message;
	
	private String errorcode;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getErrorcode() {
		return errorcode;
	}

	public void setErrorcode(String errorcode) {
		this.errorcode = errorcode;
	}

	public APIResponse(String message, String errorcode) {
		super();
		this.message = message;
		this.errorcode = errorcode;
	}

	public APIResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "APIResponse [message=" + message + ", errorcode=" + errorcode + "]";
	}
	
	

}
