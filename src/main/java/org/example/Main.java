package org.example;

import java.io.File;
import java.util.Arrays;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        final String homePath="/home/user/Downloads/";
        final List<String> searchWords = Arrays.asList("vehicula","Java","jAva","kk");
        File folder = new File(homePath);
        ReadWordFile read = new ReadWordFile();
        File[] listOfFiles = folder.listFiles();
        assert listOfFiles != null;
        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                double matchedPercentage;
                if(listOfFile.getName().endsWith("doc")){
                    matchedPercentage = read.findPercentageMatched(listOfFile.getAbsolutePath(), searchWords,false);
                    System.out.println(listOfFile.getName()+" file matched "+matchedPercentage + "%");
                }else if (listOfFile.getName().endsWith("docx")){
                    matchedPercentage = read.findPercentageMatched(listOfFile.getAbsolutePath(), searchWords,true);
                    System.out.println(listOfFile.getName()+" file matched "+matchedPercentage + "%");
                }
            }
        }
    }
}