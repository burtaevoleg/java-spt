package com.example.practice17.services;

import com.example.practice17.tables.Post;
import com.example.practice17.tables.User;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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

    public List<User> getSortedUsersByFirstName(){
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> userCriteriaQuery =
                builder.createQuery(User.class);
        Root<User> root = userCriteriaQuery.from(User.class);
        userCriteriaQuery.select(root).orderBy(builder.asc(root.get(
                "firstName")));
        Query<User> query = session.createQuery(userCriteriaQuery);
        return query.getResultList();
    }

    public List<User> getSortedUsersByLastName(){
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> userCriteriaQuery =
                builder.createQuery(User.class);
        Root<User> root = userCriteriaQuery.from(User.class);
        userCriteriaQuery.select(root).orderBy(builder.asc(root.get(
                "lastName")));
        Query<User> query = session.createQuery(userCriteriaQuery);
        return query.getResultList();
    }

    public List<User> getSortedUsersByMiddleName(){
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> userCriteriaQuery =
                builder.createQuery(User.class);
        Root<User> root = userCriteriaQuery.from(User.class);
        userCriteriaQuery.select(root).orderBy(builder.asc(root.get(
                "middleName")));
        Query<User> query = session.createQuery(userCriteriaQuery);
        return query.getResultList();
    }

    public List<User> getSortedUsersByBirthDate(){
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> userCriteriaQuery =
                builder.createQuery(User.class);
        Root<User> root = userCriteriaQuery.from(User.class);
        userCriteriaQuery.select(root).orderBy(builder.asc(root.get(
                "birthDate")));
        Query<User> query = session.createQuery(userCriteriaQuery);
        return query.getResultList();
    }

}
