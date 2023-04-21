package com.usermanagement.service;

import java.util.List;

import com.usermanagement.beans.User;
import com.usermanagement.dto.UserDto;

public interface UserService {

	public UserDto saveUser(UserDto userdto);

	public List<UserDto> getAllUser();

	public UserDto getUser(Integer id);

	public void deleteUser(Integer id);

	public UserDto updateUser(UserDto userdto, Integer id);
}
