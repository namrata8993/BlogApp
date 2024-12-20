package com.BikkadIt.BlogAppApi.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BikkadIt.BlogAppApi.entity.User;
import com.BikkadIt.BlogAppApi.exception.*;
import com.BikkadIt.BlogAppApi.payloads.UserDto;
import com.BikkadIt.BlogAppApi.repositories.UserRepo;
import com.BikkadIt.BlogAppApi.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		
		User user = this.dtoToUser(userDto);
		
		User savedUser = this.userRepo.save(user);
		return this.userToDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		
		User user = this.userRepo.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("User","id",userId));
		
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(user.getPassword());
		user.setAbout(user.getAbout());
		
		User updatedUser = this.userRepo.save(user);
		UserDto userDto1 = this.userToDto(updatedUser);
		
		return userDto1;
	}

	@Override
	public UserDto getuserById(Integer userId) {
		User user= this.userRepo.findById(userId)
				.orElseThrow(()->new ResourceNotFoundException("User", "id" , userId));
		
		
		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		
		List<User> users = this.userRepo.findAll();
		
		List<UserDto> userDtos  = users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public void deleteUser(Integer userId) {
	User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));
     this.userRepo.delete(user);

	}

	public User dtoToUser(UserDto userDto)
	{
	   User user = new User();
	   user.setId(userDto.getId());
	   user.setName(userDto.getName());
	   user.setPassword(userDto.getPassword());
	   user.setEmail(userDto.getEmail());
	   user.setAbout(userDto.getAbout());
	   
	   return user;
	   
	}
	
	public UserDto userToDto(User user)
	{
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setName(user.getName());
		userDto.setPassword(user.getPassword());
		userDto.setEmail(user.getEmail());
		userDto.setAbout(user.getAbout());
		
		return userDto;
	}
}
