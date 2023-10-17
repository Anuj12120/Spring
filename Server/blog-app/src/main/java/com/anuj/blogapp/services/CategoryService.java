package com.anuj.blogapp.services;

import java.util.List;

import com.anuj.blogapp.payloads.CategoryDTO;

public interface CategoryService {
	
	//Add / Create category
	public CategoryDTO createCategory(CategoryDTO categoryDTO);
	
	//Update Category
	public CategoryDTO updateCategory(CategoryDTO categoryDTO, Integer categoryId);
	
	//Delete Category
	public void deleteCategory(Integer categoryId);
	
	//Get all Categories
	public List<CategoryDTO> getAllCategories();
	
	//Get specific Category by id
	public CategoryDTO getSpecificCategory(Integer categoryId);
}
