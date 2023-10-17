package com.anuj.blogapp.services;

import com.anuj.blogapp.entity.Post;
import com.anuj.blogapp.payloads.PostDTO;

import java.util.List;

public interface PostService {
	
	//create post
	PostDTO createPost(PostDTO postdto, Integer userId, Integer categoryId);
	
	//update post
	PostDTO updatePost(PostDTO postDto, Integer postId);
	
	//delete Post
	void deletePost(Integer postId);
	
	//get all post
	List<PostDTO> getAllPost();
	
	//get specific post
	PostDTO getPostById(Integer postId);
	
	//get all post category
	List<PostDTO> getPostByCategory(Integer categoryId);
	
	//get all post by user
	List<PostDTO> getPostByUser(Integer userId);
	
	//search post by keyword
	List<Post> searchPost(String keyword);
	
	
}
