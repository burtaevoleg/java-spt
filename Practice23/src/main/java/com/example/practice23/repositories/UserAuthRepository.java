package com.example.practice23.repositories;

import com.example.practice23.tables.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAuthRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
