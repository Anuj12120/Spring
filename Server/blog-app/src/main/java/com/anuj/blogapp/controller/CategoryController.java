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

import com.anuj.blogapp.payloads.CategoryDTO;
import com.anuj.blogapp.services.CategoryService;
import com.anuj.blogapp.utile.ApiResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	//Create Request for create category
	@PostMapping("/")
	public ResponseEntity<CategoryDTO> createCategory(@Valid @RequestBody CategoryDTO categoryDTO){
		
		CategoryDTO categoryDTO2 = this.categoryService.createCategory(categoryDTO);
		return new ResponseEntity<CategoryDTO>(categoryDTO2, HttpStatus.CREATED);
		
	}
	
	
	//Update Request for update category
	@PutMapping("/{categoryId}")
	public ResponseEntity<CategoryDTO> updateCategory(@Valid @RequestBody CategoryDTO categoryDTO, @PathVariable Integer categoryId){
		
		CategoryDTO categoryDTO2 = this.categoryService.updateCategory(categoryDTO, categoryId);
		return new ResponseEntity<CategoryDTO>(categoryDTO2, HttpStatus.OK);
		
	}
	
	//Delete request for delete the specific category
	@DeleteMapping("/{categoryId}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer categoryId){
		
		this.categoryService.deleteCategory(categoryId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Category deleted successfully", true), HttpStatus.OK);
		
	}
	
	
	//Get Request for Get Specific User details
	@GetMapping("/{categoryId}")
	public ResponseEntity<CategoryDTO> getSpecificCategory(@PathVariable Integer categoryId){
		
		CategoryDTO categoryDTO2 = this.categoryService.getSpecificCategory(categoryId);
		return new ResponseEntity<CategoryDTO>(categoryDTO2, HttpStatus.OK);
		
	}
	
	
	
	//Get Request for Get all the User from the database
	@GetMapping("/")
	public ResponseEntity<List<CategoryDTO>> getAllCategory(){
		
		List<CategoryDTO> categoryDTO2 = this.categoryService.getAllCategories();
		return ResponseEntity.ok(categoryDTO2);
		
	}
}
