package com.springboot.blog.springbootblogrestapi.controllers;

import com.springboot.blog.springbootblogrestapi.payload.CommentDto;
import com.springboot.blog.springbootblogrestapi.services.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/ap/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/getAllByPostId")
    public Set<CommentDto> getAllByPostId(@PathVariable Long id){
        return commentService.getAllByPostId(id);
    }

    @GetMapping("/{postId/comment/{commentId}")
    public ResponseEntity<CommentDto> getById(@PathVariable Long postId, @PathVariable Long commentId){
        CommentDto commentDto =  commentService.getById(commentId, postId);

        return new ResponseEntity<>(commentDto, HttpStatus.OK);
    }

    @PutMapping("/{postId/comment/{commentId}")
    public ResponseEntity<Long> updateById(@PathVariable Long postId, @PathVariable Long commentId){
        Long id = commentService.update(commentId, postId);

        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @DeleteMapping("/{postId/comment/{commentId}")
    public ResponseEntity<Long> deleteById(@PathVariable Long postId, @PathVariable Long commentId){
        Long id = commentService.delete(commentId, postId);

        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
