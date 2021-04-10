package com.example.practice18.controllers;

import com.example.practice18.services.PostService;
import com.example.practice18.tables.Post;
import com.example.practice18.tables.User;
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

    @GetMapping(value = "/get/{postId}/user")
    @ResponseBody
    public User getDogUser(@PathVariable("postId") int postId){
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

    @GetMapping("/get/sortedByCreationDate")
    @ResponseBody
    public List<Post> getSortedPostsByCreationDate(){
        return postService.getSortedPostsByCreationDate();
    }

    @GetMapping("/get/sortedByText")
    @ResponseBody
    public List<Post> getSortedPostsByText(){
        return postService.getSortedPostsByText();
    }

    @GetMapping("/get/sortedByUserId")
    @ResponseBody
    public List<Post> getSortedPostsUserId(){
        return postService.getSortedPostsUserId();
    }
}
