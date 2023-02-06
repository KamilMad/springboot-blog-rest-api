package com.springboot.blog.springbootblogrestapi.repositories;

import com.springboot.blog.springbootblogrestapi.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
