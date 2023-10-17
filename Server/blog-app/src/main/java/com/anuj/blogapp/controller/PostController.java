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


import com.anuj.blogapp.payloads.PostDTO;
import com.anuj.blogapp.services.PostService;
import com.anuj.blogapp.utile.ApiResponse;

@RestController
@RequestMapping("/api")
public class PostController {

	@Autowired
	private PostService postService;
	
	
	//CReate Post handler
	@PostMapping("/user/{userId}/category/{categoryId}/posts")
		public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDTO, @PathVariable Integer userId, @PathVariable Integer categoryId){
			
			PostDTO createPost = this.postService.createPost(postDTO, userId, categoryId);
					
			return new ResponseEntity<PostDTO>(createPost, HttpStatus.CREATED);
		}
	
	
	//Get post by user handler
	@GetMapping("/user/{userId}/posts")
		public ResponseEntity<List<PostDTO>> getPostByUser(@PathVariable Integer userId){
			
			List<PostDTO> posts = this.postService.getPostByUser(userId);
			
			return new ResponseEntity<List<PostDTO>>(posts, HttpStatus.OK);
		}
	
	//Get post by category handler
		@GetMapping("/category/{categoryId}/posts")
		public ResponseEntity<List<PostDTO>> getPostByCategory(@PathVariable Integer categoryId){
			
			List<PostDTO> posts = this.postService.getPostByCategory(categoryId);
			
			return new ResponseEntity<List<PostDTO>>(posts, HttpStatus.OK);
		}
		
	//Get All Post
		@GetMapping("/posts")
		public ResponseEntity<List<PostDTO>> getAllPost(){
			
			List<PostDTO> posts = this.postService.getAllPost();
			
			return new ResponseEntity<List<PostDTO>>(posts, HttpStatus.OK);
		}
		
		
		
	//Get Post by Id
		@GetMapping("/posts/{postId}")
		public ResponseEntity<PostDTO> getPostById(@PathVariable Integer postId){
			
			PostDTO posts = this.postService.getPostById(postId);
			
			return new ResponseEntity<PostDTO>(posts, HttpStatus.OK);
		}
		
		
	//Delete post
		@DeleteMapping("/posts/{postId}")
		public ResponseEntity<ApiResponse> deletePost(@PathVariable Integer postId){
			this.postService.deletePost(postId);
			return ResponseEntity.ok(new ApiResponse("Post has been deleted", true));
		}
		
	//Update post
		@PutMapping("/posts/{postId}")
		public ResponseEntity<PostDTO> updatePost(@RequestBody PostDTO postdto , @PathVariable Integer postId){
			PostDTO postDto = this.postService.updatePost(postdto, postId);
			return new ResponseEntity<PostDTO>(postDto, HttpStatus.OK);
		}
		
}
































