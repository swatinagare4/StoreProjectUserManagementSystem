package com.usermanagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.usermanagement.dto.UserDto;
import com.usermanagement.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserService service;
	
	
	@PostMapping("/saveUser")
	public ResponseEntity<UserDto> saveUser(@Valid  @RequestBody  UserDto user){
		UserDto newuser = this.service.saveUser(user);
		
		return new ResponseEntity<UserDto>(newuser, HttpStatus.CREATED);	
		
	}
	
	@GetMapping("/getUser/{id}")
	public ResponseEntity<UserDto> getUser(@PathVariable("id") Integer id){
		UserDto newuser = this.service.getUser(id);
		
		return new ResponseEntity<UserDto>(newuser, HttpStatus.FOUND);	
		
	}
	
	@GetMapping("/getAllUser")
	public ResponseEntity<List<UserDto>>getAllUser(){
		List<UserDto> alluser = this.service.getAllUser();
		
		return new ResponseEntity<List<UserDto>>(alluser, HttpStatus.FOUND);		
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id")  Integer id){
		
		this.service.deleteUser(id);
		
		return new ResponseEntity<String>("User Deleteded successfully: "+id, HttpStatus.OK);
	}
	
	@PutMapping("/updateUser/{id}")
	public ResponseEntity<UserDto> updateUser(@RequestBody  UserDto user , @PathVariable("id")  Integer id){
		UserDto updateUser = this.service.updateUser(user, id);
		
		return new ResponseEntity<UserDto>(updateUser ,HttpStatus.OK);
		
		
	}

}
