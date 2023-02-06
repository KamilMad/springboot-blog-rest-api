package com.springboot.blog.springbootblogrestapi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "comments", uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String content;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post posts;
}
