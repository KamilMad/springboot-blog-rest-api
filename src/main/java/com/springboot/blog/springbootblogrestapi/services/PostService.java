package com.springboot.blog.springbootblogrestapi.services;

import com.springboot.blog.springbootblogrestapi.payload.PostDto;
import com.springboot.blog.springbootblogrestapi.payload.PostResponse;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto);

    PostResponse getAllPosts(int PageNo, int pageSize, String sortBy, String sortDir);

    PostDto getById(Long id);

    PostDto update(PostDto postDto, Long id);

    void deleteById(Long id);
}
