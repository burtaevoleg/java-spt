package com.example.practice12;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class FileHasher implements CommandLineRunner {
    private final FileService fileService;
    private final HashService hashService;

    private SourceFiles sourceFiles;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public FileHasher(FileService fileService, HashService hashService) {
        this.fileService = fileService;
        this.hashService = hashService;
    }

    @Override
    public void run(String... args) throws Exception {
        if (args.length != 2) {
            throw new Exception("You must pass the name of the two files in the arguments");
        }

        sourceFiles = new SourceFiles(args[0], args[1]);
        start();
    }

    @PostConstruct
    public void init() {
        logger.info("FileHasher initializing...");
    }

    private void start() throws IOException, NoSuchAlgorithmException {
        if (sourceFiles.getInputFile().exists()) {
            String input = fileService.readFromFile(sourceFiles.getInputFile());
            input = hashService.hashString(input);
            fileService.writeToFile(sourceFiles.getOutputFile(), input);
            return;
        }

        fileService.writeToFile(sourceFiles.getOutputFile(), "null");
    }

    @PreDestroy
    private void destroy() {
        logger.info("FileHasher destroying...");
        logger.info("Deleting the original file");
        fileService.deleteFile(sourceFiles.getInputFile());
    }
}
