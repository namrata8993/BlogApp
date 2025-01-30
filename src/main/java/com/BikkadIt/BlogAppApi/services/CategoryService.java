package com.BikkadIt.BlogAppApi.services;

import java.util.List;


import com.BikkadIt.BlogAppApi.payloads.CategoryDto;

public interface CategoryService {
	//create
	 CategoryDto createCategory(CategoryDto categoryDto);
	
	//Update
	 CategoryDto  updateCategory(CategoryDto categoryDto,Integer categoryId);
	
	//delete
	 void deleteCategory(Integer categoryId);
	
	//get
	 CategoryDto getCategory(Integer categoryId);
	
	//get all
	 List<CategoryDto> getCategories();


}
