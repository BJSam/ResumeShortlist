package org.example;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        final String homePath="/home/user/Downloads/";
        final List<String> searchWords = Arrays.asList("vehicula","Java","jAva","kk");
        File folder = new File(homePath);
        ReadWordFile read = new ReadWordFile();
        SaveToFile saveToFile = new SaveToFile();
        File[] listOfFiles = folder.listFiles();
        HashMap<String,Double> allResumeData = new HashMap<>();
        assert listOfFiles != null;
        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                if(listOfFile.getName().endsWith("doc")){
                    double matchedPercentage = read.findPercentageMatched(listOfFile.getAbsolutePath(), searchWords,false);
                    allResumeData.put(listOfFile.getName(),matchedPercentage);
                }else if (listOfFile.getName().endsWith("docx")){
                    double matchedPercentage = read.findPercentageMatched(listOfFile.getAbsolutePath(), searchWords,true);
                    allResumeData.put(listOfFile.getName(),matchedPercentage);
                }
            }
        }
        if(!allResumeData.isEmpty()){
            boolean savedData = saveToFile.excel(homePath, allResumeData);
            System.out.println("Saved data to excel ? "+savedData);
        }

    }
}