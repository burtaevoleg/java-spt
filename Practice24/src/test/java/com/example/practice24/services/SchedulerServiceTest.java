package com.example.practice24.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SchedulerServiceTest {
    private SchedulerService schedulerService;
    @MockBean
    private PostService postService;
    @MockBean
    private UserService userService;

    @Autowired
    public void setDataScheduler(SchedulerService schedulerService) {
        this.schedulerService = schedulerService;
    }

    @Test
    public void checkDataFilesExist() throws IOException {
        schedulerService.doTask();

        String path = "src/main/resources/output";
        File dir = ResourceUtils.getFile(path);
        verify(postService, times(1)).getPosts();
        verify(userService, times(1)).getUsers();
        assertTrue(dir.exists());
        String[] files = {"post_data.txt", "users_data.txt"};

        assertTrue(Arrays.stream(Objects.requireNonNull(dir.listFiles()))
                .map(File::getName)
                .collect(Collectors.toList())
                .containsAll(Arrays.asList(files)));
    }
}
