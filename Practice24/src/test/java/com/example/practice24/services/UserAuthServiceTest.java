package com.example.practice24.services;

import com.example.practice24.repositories.UserAuthRepository;
import com.example.practice24.tables.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@SpringBootTest
@RunWith(SpringRunner.class)
public class UserAuthServiceTest {
    @MockBean
    private UserAuthRepository userAuthRepository;
    private UserAuthService userAuthService;
    private PasswordEncoder passwordEncoder;
    @Captor
    private ArgumentCaptor<User> captor;

    @Autowired
    public void setUserAuthService(UserAuthService userAuthService) {
        this.userAuthService = userAuthService;
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Before
    public void setUp() {
        User user = new User();
        user.setUsername("user");
        user.setPassword("password");
        user.setUser_id(1L);

        when(userAuthRepository.findByUsername(user.getUsername()))
                .thenReturn(user);
    }

    @Test
    public void UserShouldBeRegister() {
        String encodedPassword = passwordEncoder.encode("qwerty");
        User newUser = new User();
        newUser.setUsername("user");
        newUser.setPassword(encodedPassword);
        newUser.setUser_id(2L);

        when(userAuthRepository.save(any(User.class)))
                .thenReturn(newUser);
        User user = userAuthRepository.save(newUser);

        assertThat(user).isNotNull();
        verify(userAuthRepository).save(captor.capture());
        User captured = captor.getValue();
        assertEquals(newUser.getUsername(), captured.getUsername());
    }

    @Test
    public void UserShouldBeFound() {
        String username = "user";
        UserDetails userDetails = userAuthService.loadUserByUsername(username);
        assertEquals(username, userDetails.getUsername());
    }
}
