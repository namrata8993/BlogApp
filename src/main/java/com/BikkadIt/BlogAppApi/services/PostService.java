package com.BikkadIt.BlogAppApi.services;

import java.util.List;

import com.BikkadIt.BlogAppApi.entity.Post;
import com.BikkadIt.BlogAppApi.payloads.PostDto;
import com.BikkadIt.BlogAppApi.payloads.PostResponse;

public interface PostService {
	
	//create
	
	PostDto createPost(PostDto postDto , Integer userId, Integer categoryId);
	
	//update
	
	PostDto updatePost(PostDto postDto, Integer postId);
	
	//delete 
	
	void deletePost(Integer postId);
	
	
	
	
	
	//get all post
	
	PostResponse  getAllPost(Integer PageNumber, Integer PageSize,String sortBy,String shortDir);
	
	//get single post
	
	PostDto getPostById(Integer postId);
	
	//get all post by categoy
	
	List<PostDto> getPostByCategory ( Integer categoryId);
	
	//get all post by user
	
	List<PostDto>  getPostByUser(Integer userId);
	
	//serch post
	List<PostDto> searchPosts(String keyword);
	

}
