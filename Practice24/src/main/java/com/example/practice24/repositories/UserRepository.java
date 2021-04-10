package com.example.practice24.repositories;

import com.example.practice24.tables.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer> {
}
