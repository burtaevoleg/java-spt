package com.example.practice12;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.*;

@Component
public class FileService {
    private String readFromInputStream(InputStream inputStream) throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;

            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append('\n');
            }
        }

        return resultStringBuilder.toString();
    }

    public String readFromFile(File file) throws IOException {
        return readFromInputStream(new FileInputStream(file));
    }

    public void writeToFile(File file, String data) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(data);
        writer.close();
    }

    public boolean deleteFile(File file) {
        return file.delete();
    }
}
