package com.example.practice24.services;

import com.example.practice24.repositories.UserRepository;
import com.example.practice24.tables.Users;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {
    @MockBean
    private UserRepository userRepository;

    @Captor
    private ArgumentCaptor<Users> captor;
    private UserService userService;

    @Autowired
    public void setPostOfficeService(UserService userService) {
        this.userService = userService;
    }

    private final List<Users> users = new ArrayList<>();

    @Before
    public void setUp() {
        Users user1 = new Users();
        user1.setId(0);
        user1.setFirstName("Oleg");
        user1.setLastName("B");
        user1.setMiddleName("A");
        user1.setBirthDate("03/09/2001");

        Users user2 = new Users();
        user2.setId(1);
        user2.setFirstName("Oleg2");
        user2.setLastName("B2");
        user2.setMiddleName("A2");
        user2.setBirthDate("04/09/2001");

        users.add(user1);
        users.add(user2);

        when(userRepository.findAll())
                .thenReturn(users);
    }

    @Test
    public void whenGetPosts() {
        List<Users> fetched = userService.getUsers();

        verify(userRepository, times(1))
                .findAll();
        Assertions.assertEquals(users.size(), fetched.size());
    }

    @Test
    public void addPost() {
        Users user = new Users();
        user.setId(3);
        user.setFirstName("Oleg3");
        user.setLastName("B3");
        user.setMiddleName("A3");
        user.setBirthDate("09/09/2001");
        userService.addUser(user);

        verify(userRepository).save(captor.capture());
        Users captured = captor.getValue();
        Assertions.assertEquals(user.getFirstName(), captured.getFirstName());
        Assertions.assertEquals(user.getLastName(), captured.getLastName());
        Assertions.assertEquals(user.getMiddleName(), captured.getMiddleName());
        Assertions.assertEquals(user.getBirthDate(), captured.getBirthDate());
    }

    @Test
    public void whenDelete() {
        Users user = new Users();
        user.setId(4);
        user.setFirstName("Oleg4");
        user.setLastName("B4");
        user.setMiddleName("A4");
        user.setBirthDate("12/09/2001");
        userService.addUser(user);

        verify(userRepository).save(captor.capture());
        Users captured = captor.getValue();
        System.out.println(captured.getId());

        when(userRepository.findById(captured.getId()))
                .thenReturn(Optional.of(captured));
        when(userRepository.existsById(captured.getId()))
                .thenReturn(true);

        userService.deleteUser(captured.getId());
        verify(userRepository, times(1))
                .deleteById(captured.getId());
    }
}
