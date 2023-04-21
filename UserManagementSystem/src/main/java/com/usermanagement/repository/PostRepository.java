package com.usermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usermanagement.beans.Post;

public interface PostRepository extends JpaRepository<Post, Integer>{

}
