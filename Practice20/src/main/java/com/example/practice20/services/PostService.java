package com.example.practice20.services;

import com.example.practice20.repositories.PostRepository;
import com.example.practice20.tables.Post;
import com.example.practice20.tables.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    public void addPost(Post post){
        postRepository.save(post);
    }

    public String deletePost(int id){
        if( postRepository.existsById(id)){
            postRepository.deleteById(id);
            return "Post deleted";
        }
        return "Post is not found";
    }

    public User getUserByPost(int postId) {
        return postRepository.findById(postId).orElseThrow(() ->
                new IllegalStateException("Post with this id notfound")).getUser();
    }

    public List<Post> getSortedPostsByCreationDate(){
        return postRepository.findAll(Sort.by("creationDate"));
    }

    public List<Post> getSortedPostsByText(){
        return postRepository.findAll(Sort.by("text"));
    }

    public List<Post> getSortedPostsUserId(){
        return postRepository.findAll(Sort.by("userId"));
    }

}
