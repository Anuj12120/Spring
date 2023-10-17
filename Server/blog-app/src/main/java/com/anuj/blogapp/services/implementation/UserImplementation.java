package com.anuj.blogapp.services.implementation;

import java.util.List;
import java.util.stream.Collectors;

import com.anuj.blogapp.exceptions.*;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anuj.blogapp.entity.User;
import com.anuj.blogapp.payloads.UserDTO;
import com.anuj.blogapp.repository.UserRepo;
import com.anuj.blogapp.services.UserService;


@Service
public class UserImplementation implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UserDTO createUser(UserDTO user) {
		User users = this.dtoTOuser(user);
		User saveUser = this.userRepo.save(users);
		return this.userTodto(saveUser);
	}

	@Override
	public UserDTO updateUser(UserDTO user, Integer userId) {
		User users = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "id", userId));
		
		users.setName(user.getName());
		users.setEmail(user.getEmail());
		users.setPassword(user.getPassword());
		users.setAbout(user.getAbout());
		User updateUser = this.userRepo.save(users);
		
		return this.userTodto(updateUser);
	}

	@Override
	public UserDTO getUserById(Integer userId) {
		User users = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "id", userId));
		
		return this.userTodto(users);
	}

	@Override
	public List<UserDTO> getAllUsers() {
		List<User> users = this.userRepo.findAll();
		
		List<UserDTO> userDTO = users.stream().map(user-> this.userTodto(user)).collect(Collectors.toList());
		
		return userDTO;
	}

	@Override
	public void deleteUser(Integer userId) {
		User users = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "id", userId));
		this.userRepo.delete(users);

	}
	
	private User dtoTOuser(UserDTO user) {
//		User use = new User();
		
//		use.setName(user.getName());
//		use.setEmail(user.getEmail());
//		use.setPassword(user.getPassword());
//		use.setAbout(user.getAbout());
//		use.setUser_id(user.getUser_id());
		
		User users = this.modelMapper.map(user, User.class);
		
		return users;
		
	}
	private UserDTO userTodto(User user) {
//		UserDTO use = new UserDTO();
//		
//		use.setName(user.getName());
//		use.setEmail(user.getEmail());
//		use.setPassword(user.getPassword());
//		use.setAbout(user.getAbout());
//		use.setUser_id(user.getUser_id());
		
		UserDTO use = this.modelMapper.map(user, UserDTO.class);
		
		return use;
		
	}

}
