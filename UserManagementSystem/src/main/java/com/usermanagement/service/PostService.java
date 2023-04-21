package com.usermanagement.service;

import com.usermanagement.dto.PostDto;

public interface PostService {
	
	public PostDto createPost(PostDto postdto, Integer userid);

}
