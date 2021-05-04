package com.example.practice22.services;

import com.example.practice22.tables.Post;
import com.example.practice22.tables.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Component
@Slf4j
@ManagedResource(
        objectName = "Practice22MBeans:category=MBeans,name=DataScheduler"
)
public class SchedulerService {
    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;

    @Scheduled(cron = "0 0/30 * * * *")
    @ManagedOperation(description = "Clear output, create .txt with database data")
    public void doTask() throws IOException {
        log.info("Task started");
        File file_dir = ResourceUtils.getFile("src/main/resources/output");
        try {
            for (File file : file_dir.listFiles())
                if (file.isFile()) file.delete();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        log.info("Files deleted");
        BufferedWriter postFile = new BufferedWriter(new FileWriter(file_dir.getAbsolutePath() + "/post_data.txt"));
        BufferedWriter userFile = new BufferedWriter(new FileWriter(file_dir.getAbsolutePath() + "/users_data.txt"));
        postFile.write("id\tuser_id\ttext\tcreation date\n");
        for (Post post : postService.getPosts())
            postFile.write(String.format("%d\t%d\t%s\t%s\n", post.getId(), post.getUserId(), post.getText(), post.getCreationDate()));
        postFile.close();
        userFile.write("id\tfirst name\tlast name\tmiddle name\tbirth date\n");
        for (User user : userService.getUsers())
            userFile.write(String.format("%d\t%s\t%s\t%s\t%s\n", user.getId(), user.getFirstName(), user.getLastName(), user.getMiddleName(), user.getBirthDate()));
        userFile.close();
    }
}
