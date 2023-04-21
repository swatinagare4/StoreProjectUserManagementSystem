package com.usermanagement.service.impl;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usermanagement.beans.Post;
import com.usermanagement.beans.User;
import com.usermanagement.dto.PostDto;
import com.usermanagement.exception.UserNotFoundException;
import com.usermanagement.repository.PostRepository;
import com.usermanagement.repository.UserRepository;
import com.usermanagement.service.PostService;


@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostRepository postrepo;
	
	@Autowired
	private ModelMapper  mapper;
	
	@Autowired
	private UserRepository userrepo;

	@Override
	public PostDto createPost(PostDto postdto, Integer userid) {
		
		//Finding User
		User user = this.userrepo.findById(userid).orElseThrow(()->new UserNotFoundException("User", "User", userid));
		 //Converting Dto to Entity
		Post post = this.mapper.map(postdto, Post.class);
		 
		//Hardcpded Values set
		 post.setImagename("swati.png");
		 post.setAddeddate(new Date());
		 post.setUser(user);
		 
		 //we are saving post into Database
		 Post newpost=postrepo.save(post);
		 
		 //Convert Entity to Dto
		 PostDto updatePost = this.mapper.map(newpost, PostDto.class);
		
		
		return updatePost;
	}
	
	

}
