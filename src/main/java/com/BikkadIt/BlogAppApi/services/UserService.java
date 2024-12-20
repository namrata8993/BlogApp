package com.BikkadIt.BlogAppApi.services;

import java.util.List;


import com.BikkadIt.BlogAppApi.entity.User;
import com.BikkadIt.BlogAppApi.payloads.UserDto;

public interface UserService {

	UserDto createUser( UserDto user);
	
	UserDto updateUser(UserDto user,Integer userId);
	
	UserDto getuserById(Integer UserId);
	
	List<UserDto> getAllUsers();
	
	void deleteUser(Integer userId);
}
