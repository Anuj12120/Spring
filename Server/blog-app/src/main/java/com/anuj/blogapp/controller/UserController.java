package com.anuj.blogapp.controller;


import java.util.List;

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

import com.anuj.blogapp.payloads.UserDTO;
import com.anuj.blogapp.services.UserService;
import com.anuj.blogapp.utile.ApiResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	//this methods create the new user in the database 
	@PostMapping("/")
	public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userdto){
		System.out.println("Request is comming");
		UserDTO createUserDTO = this.userService.createUser(userdto);
		return new ResponseEntity<>(createUserDTO, HttpStatus.CREATED);
	}
	
	//PUT Mapping for update user
	@PutMapping("/{userId}")
	public ResponseEntity<UserDTO> updateUser(@Valid @RequestBody UserDTO userDTO,@PathVariable("userId") Integer uid ){
		UserDTO updatedUser = this.userService.updateUser(userDTO, uid);
		return ResponseEntity.ok(updatedUser);
	}
	
	//DELETE user from database
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer uid){
		this.userService.deleteUser(uid);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User has been deleted", true), HttpStatus.OK);
	}
	
	//GET all the users from the database
	@GetMapping("/")
	public ResponseEntity<List<UserDTO>> getAllTheUsers(){
		return ResponseEntity.ok(this.userService.getAllUsers());
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserDTO> getSpecificUser(@PathVariable("userId") Integer uid){
		return ResponseEntity.ok(this.userService.getUserById(uid));
	}
}
