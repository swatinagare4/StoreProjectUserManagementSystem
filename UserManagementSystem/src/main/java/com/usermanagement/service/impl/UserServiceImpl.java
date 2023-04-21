package com.usermanagement.service.impl;

import java.util.List;

import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.usermanagement.beans.User;
import com.usermanagement.dto.UserDto;
import com.usermanagement.exception.UserNotFoundException;
import com.usermanagement.repository.UserRepository;
import com.usermanagement.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private UserRepository repository;

	@Override
	public UserDto saveUser(UserDto userdto) {

		// step1: DTO TO Entity convert
		User newuser = this.mapper.map(userdto, User.class);

		// Step2: Database save the Object
		User save = this.repository.save(newuser);

		// Step3: Entity to DTO
		UserDto updateduser = this.mapper.map(save, UserDto.class);

		return updateduser;
	}

	@Override
	public List<UserDto> getAllUser() {

		List<User> alluser = this.repository.findAll();

		List<UserDto> collect = alluser.stream().map((list) -> this.mapper.map(list, UserDto.class))
				.collect(Collectors.toList());

		return collect;
	}

	@Override
	public UserDto getUser(Integer id) {
		User newuser = this.repository.findById(id).orElseThrow(() -> new UserNotFoundException("User", "id", id));
		UserDto updated = this.mapper.map(newuser, UserDto.class);
		return updated;
	}

	@Override
	public void deleteUser(Integer id) {
		User user = this.repository.findById(id).orElseThrow(() -> new UserNotFoundException("User", "id", id));

		this.repository.delete(user);

	}

	@Override
	public UserDto updateUser(UserDto user, Integer id) {

		// Optional<User> users = this.repository.findById(id);

		User user2 = this.repository.findById(id).orElseThrow(() -> new UserNotFoundException("User", "id", id));

		user2.setName(user.getName());
		user2.setAddress(user.getAddress());
		user2.setEmail(user.getEmail());
		user2.setPhoneno(user.getPhoneno());
		user2.setPassword(user.getPassword());

		this.repository.save(user2);

		UserDto updateuser = this.mapper.map(user2, UserDto.class);

		return updateuser;
	}
	
	public User DtoToUser(UserDto userdto) {
		User user=new User(userdto.getName(), userdto.getAddress(), 
				userdto.getEmail(), userdto.getPhoneno(),
				userdto.getPassword());
		return user;
	}
	
	
	public UserDto UserTODto(User user) {
		UserDto userdto=new UserDto(user.getName(), user.getAddress(), 
				user.getEmail(), user.getPhoneno(),
				user.getPassword());
		return userdto;
	}

}
