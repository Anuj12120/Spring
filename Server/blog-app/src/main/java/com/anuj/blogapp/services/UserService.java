package com.anuj.blogapp.services;

import java.util.List;

import com.anuj.blogapp.payloads.UserDTO;

//it is interface which help to implement all CRUD operation of the user

public interface UserService {
	
	//method to create user
	UserDTO createUser(UserDTO user); 
	
	//method to update user data
	UserDTO updateUser(UserDTO user, Integer userId);
	
	//it will te specific user data
	UserDTO getUserById(Integer userId);
	
	//it will gave all the user in the database
	List<UserDTO> getAllUsers(); 
	
	//it will delete the specific user from the database
	void deleteUser(Integer userId);
}
