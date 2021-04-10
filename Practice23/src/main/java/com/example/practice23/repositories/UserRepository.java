package com.example.practice23.repositories;

import com.example.practice23.tables.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer> {
}
