package com.example.practice16.controllers;

import com.example.practice16.services.PostService;
import com.example.practice16.tables.Post;
import com.example.practice16.tables.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/post")
public class PostControllers {

    @Autowired
    private PostService postService;

    @PostMapping("/add")
    @ResponseBody
    public String addPost(  @RequestParam int userId,
                            @RequestParam String text,
                            @RequestParam String creationDate){
        Post post = new Post();
        post.setText(text);
        post.setCreationDate(creationDate);
        post.setUserId(userId);
        postService.addPost(post);
        return "Post added";
    }

    @GetMapping(value = "/{postId}/user")
    @ResponseBody
    public User getPostUser(@PathVariable("postId") int postId){
        return postService.getUserByPost(postId);
    }


    @DeleteMapping("/delete")
    @ResponseBody
    public String deletePost(@RequestParam int id){
        return postService.deletePost(id);
    }

    @GetMapping("/get")
    @ResponseBody
    public List<Post> getPosts(){
        return postService.getPosts();
    }
}
