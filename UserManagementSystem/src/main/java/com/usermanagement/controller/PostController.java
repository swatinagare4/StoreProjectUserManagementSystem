package com.usermanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.usermanagement.dto.PostDto;
import com.usermanagement.service.PostService;

@RestController
public class PostController {

	@Autowired
	private PostService postService;

	@PostMapping("/user/{userid}/post")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postdto, @PathVariable("userid") Integer userid) {

		PostDto createPost = this.postService.createPost(postdto, userid);

		return new ResponseEntity<PostDto>(createPost, HttpStatus.CREATED);

	}

}
