package com.springboot.blog.springbootblogrestapi.services.impl;

import com.springboot.blog.springbootblogrestapi.entities.Comment;
import com.springboot.blog.springbootblogrestapi.entities.Post;
import com.springboot.blog.springbootblogrestapi.exception.BlogApiException;
import com.springboot.blog.springbootblogrestapi.exception.ResourceNotFoundException;
import com.springboot.blog.springbootblogrestapi.payload.CommentDto;
import com.springboot.blog.springbootblogrestapi.repositories.CommentRepository;
import com.springboot.blog.springbootblogrestapi.repositories.PostRepository;
import com.springboot.blog.springbootblogrestapi.services.CommentService;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @Override
    public Set<CommentDto> getAllByPostId(Long id) {
        Set<Comment> comments = commentRepository.findByPostId(id);

        return comments.stream().map(c -> mapCommentToDto(c)).collect(Collectors.toSet());
    }

    @Override
    public CommentDto getById(Long commentId, Long postId) {

        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Comment","id", postId));

        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("Comment","id", commentId));

        if (!comment.getPosts().getId().equals(post.getId())){
            throw new BlogApiException(HttpStatus.BAD_REQUEST, "Comment does not belong to post");
        }
         return mapCommentToDto(comment);
    }

    @Override
    public Long update(Long commentId, Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Comment","id", postId));

        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("Comment","id", commentId));

        if (!comment.getPosts().getId().equals(post.getId())){
            throw new BlogApiException(HttpStatus.BAD_REQUEST, "Comment does not belong to post");
        }
        commentRepository.save(comment);

        return comment.getId();
    }

    public CommentDto mapCommentToDto(Comment comment){
        CommentDto commentDto = new CommentDto();
        commentDto.setId(comment.getId());
        commentDto.setName(comment.getName());
        commentDto.setEmail(comment.getEmail());
        commentDto.setContent(comment.getContent());
        return commentDto;
    }

    public Comment mapDtoToComment(CommentDto commentDto){
        Comment comment = new Comment();
        comment.setId(commentDto.getId());
        comment.setName(commentDto.getName());
        comment.setEmail(commentDto.getEmail());
        comment.setContent(commentDto.getContent());
        return comment;
    }
}
