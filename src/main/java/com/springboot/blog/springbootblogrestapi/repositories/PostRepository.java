package com.springboot.blog.springbootblogrestapi.repositories;

import com.springboot.blog.springbootblogrestapi.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
