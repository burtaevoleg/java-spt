package com.example.practice15.services;

import com.example.practice15.tables.User;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UserService {
    private final SessionFactory sessionFactory;
    private Session session;
    @PostConstruct
    void init() {
        session = sessionFactory.openSession();
    }
    public List<User> getUsers() {return session.createQuery("select u from User u",
            User.class).getResultList();
    }

    public void addUser(User user){
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(user);
        transaction.commit();
    }

    public String deleteUser(int id){
        Transaction transaction = session.beginTransaction();
        User user = session.find(User.class, id);
        if( user == null){
            return "User is not found";
        }
        session.delete(user);
        transaction.commit();
        return "User deleted";
    }

}
