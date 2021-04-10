package com.example.practice24.services;

import com.example.practice24.repositories.PostRepository;
import com.example.practice24.tables.Post;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PostServiceTest {
    @MockBean
    private PostRepository postRepository;

    @Captor
    private ArgumentCaptor<Post> captor;
    private PostService postService;

    @Autowired
    private EmailService emailService;

    @Autowired
    public void setPostOfficeService(PostService postService) {
        this.postService = postService;
    }
    private final List<Post> posts = new ArrayList<>();
    @Before
    public void setUp(){
        Post post1 =new Post();
        post1.setId(0);
        post1.setText("Hello");
        post1.setCreationDate("01/01/2021");
        post1.setUserId(1);

        Post post2 =new Post();
        post2.setId(1);
        post2.setText("Hello2");
        post2.setCreationDate("02/02/2021");
        post2.setUserId(2);
        posts.add(post1);
        posts.add(post2);

        when(postRepository.findAll())
                .thenReturn(posts);
    }

    @Test
    public void whenGetPosts(){
        List<Post> fetched = postService.getPosts();

        verify(postRepository, times(1))
                .findAll();
        Assertions.assertEquals(posts.size(), fetched.size());
    }

    @Test
    public void addPost(){
        Post post = new Post();
        post.setText("World");
        post.setCreationDate("09/09/2020");
        post.setUserId(1);
        postService.addPost(post);

        verify(postRepository).save(captor.capture());
        Post captured = captor.getValue();
        Assertions.assertEquals(post.getText(), captured.getText());
        Assertions.assertEquals(post.getCreationDate(), captured.getCreationDate());
        Assertions.assertEquals(post.getUserId(), captured.getUserId());
    }

    @Test
    public void whenDelete() {
        Post post = new Post();
        post.setId(3);
        post.setText("whenDelete");
        post.setCreationDate("05/04/2021");
        post.setUserId(3);
        postService.addPost(post);

        verify(postRepository).save(captor.capture());
        Post captured = captor.getValue();
        System.out.println(captured.getId());

        when(postRepository.findById(captured.getId()))
                .thenReturn(Optional.of(captured));
        when(postRepository.existsById(captured.getId()))
                .thenReturn(true);

        postService.deletePost(captured.getId());
        verify(postRepository, times(1))
                .deleteById(captured.getId());
    }
}
