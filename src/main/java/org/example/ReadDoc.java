package org.example;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.List;

public class ReadDoc {
    public void read(){
        final String homePath="/home/user/Downloads/";
        final String fileName = "file-sample_100kB.doc";
        List<String> searchWords = Arrays.asList("vehicula","Java","jAva","Vestibulum");
        File file = null;
        WordExtractor extractor = null;
        try
        {

            file = new File(homePath+fileName);
            FileInputStream fis = new FileInputStream(file.getAbsolutePath());
            HWPFDocument document = new HWPFDocument(fis);
            extractor = new WordExtractor(document);
            System.out.println(searchWords);
            String finalExtractorString = extractor.getText().toLowerCase();
            boolean doesItContain =  searchWords.stream()
                    .map(String::toLowerCase)
                    .anyMatch(finalExtractorString::contains);
            System.out.println(doesItContain);
//            String[] fileData = extractor.getParagraphText();
//            for (int i = 0; i < fileData.length; i++)
//            {
//                if (fileData[i] != null)
//                    System.out.println(fileData[i]);
//            }
        }
        catch (Exception exep)
        {
            exep.printStackTrace();
        }
    }
}
