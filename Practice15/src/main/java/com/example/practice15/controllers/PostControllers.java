package com.example.practice15.controllers;

import com.example.practice15.services.PostService;
import com.example.practice15.tables.Post;
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
    public String addPost(  @RequestParam String text,
                            @RequestParam String creationDate){
        Post post = new Post();
        post.setText(text);
        post.setCreationDate(creationDate);
        postService.addPost(post);
        return "Post added";
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
