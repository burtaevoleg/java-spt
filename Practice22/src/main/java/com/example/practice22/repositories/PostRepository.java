package com.example.practice22.repositories;

import com.example.practice22.tables.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
