package com.anuj.blogapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anuj.blogapp.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{
	
}
