package com.springboot.blog.springbootblogrestapi.payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Set;

@Data
public class PostDto {

    private Long id;

    @NotNull
    @NotEmpty
    @Size(min = 2, message = "Post title should have at least two characters")
    private String title;

    @NotNull
    @NotEmpty
    @Size(min = 10, message = "Description should be at least 10 character long")
    private String description;

    @NotEmpty
    private String content;

    Set<CommentDto> comments;
}
