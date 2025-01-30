package com.BikkadIt.BlogAppApi.services;

import java.util.List;

import com.BikkadIt.BlogAppApi.entity.Post;
import com.BikkadIt.BlogAppApi.payloads.PostDto;

public interface PostService {
	
	//create
	
	PostDto createPost(PostDto postDto , Integer userId, Integer categoryId);
	
	//update
	
	Post updatePost(PostDto postDto, Integer postId);
	
	//delete 
	
	void deletePost(Integer postId);
	
	//get all post
	
	List<Post>  getAllPost();
	
	//get single post
	
	Post getPostById(Integer postId);
	
	//get all post by categoy
	
	List<PostDto> getPostByCategory ( Integer categoryId);
	
	//get all post by user
	
	List<PostDto>  getPostByUser(Integer userId);
	
	//serch post
	List<Post> serchPost(String keyword);
	

}
