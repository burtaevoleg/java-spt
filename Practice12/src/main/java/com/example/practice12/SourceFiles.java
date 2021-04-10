package com.example.practice12;

import lombok.Getter;
import lombok.Setter;

import java.io.File;

@Getter
@Setter
public class SourceFiles {
    private File inputFile;
    private File outputFile;

    public SourceFiles(String inputFileName, String outputFileName) {
        this.inputFile = new File(inputFileName);
        this.outputFile = new File(outputFileName);
    }
}
