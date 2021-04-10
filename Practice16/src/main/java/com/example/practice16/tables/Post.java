package com.example.practice16.tables;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table (name = "posts")
public class Post {
    @Id
    @SequenceGenerator(name = "posts_seq", sequenceName =
            "posts_sequence", allocationSize = 1)
    @GeneratedValue(generator = "posts_seq", strategy =
            GenerationType.SEQUENCE)
    private int id;
    @Column(name = "text")
    private String text;
    @Column(name = "creationDate")
    private String creationDate;
    @Column(name = "user_id")
    private int userId;
    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    @JsonIgnore
    private User user;
}
