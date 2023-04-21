package com.usermanagement.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<APIResponse> userNotFoundException(UserNotFoundException ex) {
		
		String message = ex.getMessage();
		
		APIResponse apiResponse=new APIResponse(message, ErrorCode.USERNd);
		
		return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.NOT_FOUND);

	}

	
	@ExceptionHandler(MethodArgumentNotValidException.class)
public ResponseEntity<Map<String, String>> handelMethodArgument(MethodArgumentNotValidException ex){
		
		Map<String, String> data=new HashMap<>();
		
		ex.getBindingResult().getAllErrors().forEach((error)->{
			
			String field=((FieldError)error).getField();
			
			String defaultMsg=error.getDefaultMessage();
			
			data.put(field, defaultMsg);
			});
	return new ResponseEntity<Map<String,String>>(data,HttpStatus.BAD_REQUEST);
	
}
}
