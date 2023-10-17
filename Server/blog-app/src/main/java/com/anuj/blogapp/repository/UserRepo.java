package com.anuj.blogapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anuj.blogapp.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
