package com.example.practice21.repositories;

import com.example.practice21.tables.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
