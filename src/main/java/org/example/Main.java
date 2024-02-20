package org.example;

import java.util.Arrays;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        final String homePath="/home/user/Downloads/";
        final String fileName = "file-sample_100kB.doc";
        final List<String> searchWords = Arrays.asList("vehicula","Java","jAva","Vestibulum");
        ReadWordFile read = new ReadWordFile();
        boolean isShortListed = read.checkForShortlisting(homePath + fileName, searchWords);
        System.out.println("is short listed? "+isShortListed);
    }
}