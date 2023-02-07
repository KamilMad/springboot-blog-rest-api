package com.springboot.blog.springbootblogrestapi.repositories;

import com.springboot.blog.springbootblogrestapi.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    Set<Comment> findByPostId(long postId);
}
