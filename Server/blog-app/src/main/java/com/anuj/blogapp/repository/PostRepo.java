package com.anuj.blogapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anuj.blogapp.entity.Category;
import com.anuj.blogapp.entity.Post;
import com.anuj.blogapp.entity.User;

public interface PostRepo extends JpaRepository<Post, Integer> {
	
	List<Post> findByUser(User user);
	List<Post> findByCategory(Category category);

}
