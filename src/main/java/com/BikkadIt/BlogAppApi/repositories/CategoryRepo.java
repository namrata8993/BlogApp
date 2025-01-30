package com.BikkadIt.BlogAppApi.repositories;

//import java.util.List;

//import java.util.Locale.Category;


import org.springframework.data.jpa.repository.JpaRepository;

import com.BikkadIt.BlogAppApi.entity.Category;

//import com.BikkadIt.BlogAppApi.payloads.CategoryDto;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
	
	
}
