package com.springboot.blog.springbootblogrestapi.services;

import com.springboot.blog.springbootblogrestapi.payload.CommentDto;

import java.util.Set;

public interface CommentService {

    Set<CommentDto> getAllByPostId(Long postId);
}
