package com.example.practice14.dto;

import com.example.practice14.models.Post;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PostDto {
    private final List<Post> posts= new ArrayList<>();

    public void addPost(Post post){
        posts.add(post);
    }

    public void deletePost(int id){
        posts.removeIf( post -> post.getId() == id);
    }

    public String getPosts() {
        return posts.toString();
    }
}
