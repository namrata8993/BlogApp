package com.BikkadIt.BlogAppApi.services.impl;

import java.util.Date;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BikkadIt.BlogAppApi.entity.Category;
import com.BikkadIt.BlogAppApi.entity.Post;
import com.BikkadIt.BlogAppApi.entity.User;
import com.BikkadIt.BlogAppApi.exception.ResourceNotFoundException;
import com.BikkadIt.BlogAppApi.payloads.PostDto;
import com.BikkadIt.BlogAppApi.repositories.CategoryRepo;
import com.BikkadIt.BlogAppApi.repositories.PostRepo;
import com.BikkadIt.BlogAppApi.repositories.UserRepo;
import com.BikkadIt.BlogAppApi.services.PostService;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
@Autowired
	private UserRepo userRepo;

@Autowired
private CategoryRepo categoryRepo;

	@Override
	public PostDto createPost(PostDto postDto , Integer userId, Integer categoryId) {
		
		
		User user = this.userRepo.findById(userId) .orElseThrow(()-> new ResourceNotFoundException("User", "User Id", userId));
		
		Category category = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "Category Id", categoryId));
		
	    Post post = this.modelMapper.map(postDto, Post.class);
	    post.setImageName("default.png");
		post.setAddedDate(new Date());
		post.setUser(user);
		post.setCategory(category);
		
		Post newPost = this.postRepo.save(post);
		
		return this.modelMapper.map(newPost, PostDto.class );
	}

	@Override
	public Post updatePost(PostDto postDto, Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePost(Integer postId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Post> getAllPost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post getPostById(Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDto> getPostByCategory(Integer categoryId) {
		
		Category cat = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "category id", categoryId));
		List<Post> posts = this.postRepo.findByCategory(cat);
		
		List<PostDto> postDtos = posts.stream().map((post) -> this.modelMapper.map(posts, PostDto.class))
				.collect(Collectors.toList());
		
          return postDtos;
	}

	@Override
	public List<PostDto> getPostByUser(Integer userId) {
		
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "userId", userId));
		List<Post> posts = this.postRepo.findByUser(user);
		
		List<PostDto> postDtos = posts.stream().map((post) -> this.modelMapper.map(posts, PostDto.class))
				.collect(Collectors.toList());
		
		
		return postDtos;
	}

	@Override
	public List<Post> serchPost(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
