package com.example.practice24.services;

import com.example.practice24.repositories.UserAuthRepository;
import com.example.practice24.tables.Role;
import com.example.practice24.tables.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserAuthService implements UserDetailsService {
    @Autowired
    UserAuthRepository userAuthRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userAuthRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }

    public User findUserById(Long userId) {
        Optional<User> userFromDb = userAuthRepository.findById(userId);
        return userFromDb.orElse(new User());
    }

    public List<User> allUsers() {
        return userAuthRepository.findAll();
    }

    public boolean saveUser(User user, String cookie) {
        User userFromDB = userAuthRepository.findByUsername(user.getUsername());

        if (userFromDB != null) {
            return false;
        }

        user.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setSessionID(cookie);
        userAuthRepository.save(user);
        return true;
    }

    public boolean deleteUser(Long userId) {
        if (userAuthRepository.findById(userId).isPresent()) {
            userAuthRepository.deleteById(userId);
            return true;
        }
        return false;
    }
}
