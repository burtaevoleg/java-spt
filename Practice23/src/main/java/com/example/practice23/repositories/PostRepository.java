package com.example.practice23.repositories;

import com.example.practice23.tables.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
