package org.example;

import java.io.File;
import java.util.Arrays;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        final String homePath="/home/user/Downloads/";
        final List<String> searchWords = Arrays.asList("vehicula","Java","jAva","Vestibulum");
        File folder = new File(homePath);
        ReadWordFile read = new ReadWordFile();
        File[] listOfFiles = folder.listFiles();
        assert listOfFiles != null;
        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile() && listOfFile.getName().endsWith("doc")) {
                boolean isShortListed = read.checkForShortlisting(listOfFile.getAbsolutePath(), searchWords);
                System.out.println("is "+listOfFile.getName()+" file short listed? "+isShortListed);
            }
        }
    }
}