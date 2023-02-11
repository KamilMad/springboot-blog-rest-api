package com.springboot.blog.springbootblogrestapi.services;

import com.springboot.blog.springbootblogrestapi.payload.CommentDto;

import java.util.Set;

public interface CommentService {

    Set<CommentDto> getAllByPostId(Long postId);

    CommentDto getById(Long commentId, Long postId);

    Long update(Long commentId, Long postId);

    Long delete(Long commentId, Long postId);
}
