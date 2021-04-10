package com.example.practice16.services;

import com.example.practice16.tables.Post;
import com.example.practice16.tables.User;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PostService {
    private final SessionFactory sessionFactory;
    private Session session;
    @PostConstruct
    void init() {
        session = sessionFactory.openSession();
    }
    public List<Post> getPosts() {return session.createQuery("select u from Post u",
            Post.class).getResultList();
    }

    public void addPost(Post post){
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(post);
        transaction.commit();
    }

    public String deletePost(int id){
        Transaction transaction = session.beginTransaction();
        Post post = session.find(Post.class, id);
        if( post == null){
            return "Post is not found";
        }
        session.delete(post);
        transaction.commit();
        return "Post deleted";
    }

    public User getUserByPost(int postId) {
        return session.createQuery("FROM Post where id = :id", Post.class)
                .setParameter("id", postId).getSingleResult().getUser();
    }

}
