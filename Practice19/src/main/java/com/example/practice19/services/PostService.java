package com.example.practice19.services;

import com.example.practice19.repositories.PostRepository;
import com.example.practice19.tables.Post;
import com.example.practice19.tables.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostService {
    private final PostRepository postRepository;
    public List<Post> getPosts() {
        log.info("Get all posts");
        return postRepository.findAll();
    }

    public void addPost(Post post){
        log.info("Add post");
        postRepository.save(post);
    }

    public String deletePost(int id){
        if( postRepository.existsById(id)){
            postRepository.deleteById(id);
            log.debug("Post deleted");
            return "Post deleted";
        }
        log.error("Post is not found");
        return "Post is not found";
    }

    public User getUserByPost(int postId) {
        return postRepository.findById(postId).orElseThrow(() ->
                new IllegalStateException("Post with this id notfound")).getUser();
    }

    public List<Post> getSortedPostsByCreationDate(){
        log.info("Get sorted posts by creation_date");
        return postRepository.findAll(Sort.by("creationDate"));
    }

    public List<Post> getSortedPostsByText(){
        log.info("Get sorted posts by text");
        return postRepository.findAll(Sort.by("text"));
    }

    public List<Post> getSortedPostsUserId(){
        log.info("Get sorted posts by user_id");
        return postRepository.findAll(Sort.by("userId"));
    }

}
