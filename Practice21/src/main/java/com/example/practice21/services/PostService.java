package com.example.practice21.services;

import com.example.practice21.repositories.PostRepository;
import com.example.practice21.tables.Post;
import com.example.practice21.tables.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    @Autowired
    private EmailService emailService;

    @Transactional(readOnly = true)
    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    @Transactional
    public void addPost(Post post){
        emailService.sendMail("Add new post","Add new post with this text: " + post.getText());
        postRepository.save(post);
    }

    @Transactional
    public String deletePost(int id){
        if( postRepository.existsById(id)){
            postRepository.deleteById(id);
            return "Post deleted";
        }
        return "Post is not found";
    }

    @Transactional(readOnly = true)
    public User getUserByPost(int postId) {
        return postRepository.findById(postId).orElseThrow(() ->
                new IllegalStateException("Post with this id notfound")).getUser();
    }

    @Transactional(readOnly = true)
    public List<Post> getSortedPostsByCreationDate(){
        return postRepository.findAll(Sort.by("creationDate"));
    }

    @Transactional(readOnly = true)
    public List<Post> getSortedPostsByText(){
        return postRepository.findAll(Sort.by("text"));
    }

    @Transactional(readOnly = true)
    public List<Post> getSortedPostsUserId(){
        return postRepository.findAll(Sort.by("userId"));
    }

}
