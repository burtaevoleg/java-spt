package com.example.practice14.controllers;

import com.example.practice14.dto.PostDto;
import com.example.practice14.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/post")
public class PostControllers {

    @Autowired
    private PostDto postDto;

    private static int ID = 0;

    @PostMapping("/add")
    @ResponseBody
    public String addPost(  @RequestParam String text,
                            @RequestParam String creationDate){
        Post post = new Post(ID++, text, creationDate);
        postDto.addPost(post);
        return "Post added";
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public String deletePost(@RequestParam int id){
        postDto.deletePost(id);
        return "Post deleted";
    }

    @GetMapping("/get")
    @ResponseBody
    public String getPosts(){
        return postDto.getPosts();
    }
}
