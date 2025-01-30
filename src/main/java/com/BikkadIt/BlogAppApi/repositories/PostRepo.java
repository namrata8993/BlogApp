package com.BikkadIt.BlogAppApi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BikkadIt.BlogAppApi.entity.Category;
import com.BikkadIt.BlogAppApi.entity.Post;
import com.BikkadIt.BlogAppApi.entity.User;

public interface PostRepo extends JpaRepository<Post, Integer>{

	List<Post> findByUser(User user);
	List<Post> findByCategory(Category categoy);
	


	
	
}

