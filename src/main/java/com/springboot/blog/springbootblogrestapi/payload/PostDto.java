package com.springboot.blog.springbootblogrestapi.payload;

import lombok.Data;

import java.util.Set;

@Data
public class PostDto {

    private Long id;
    private String title;
    private String description;
    private String content;

    Set<CommentDto> comments;
}
