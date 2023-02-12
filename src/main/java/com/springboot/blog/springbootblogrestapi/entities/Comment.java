package com.springboot.blog.springbootblogrestapi.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
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
