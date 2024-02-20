package org.example;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

public class ReadWordFile {
    private String readDoc(String filePath){
        File file = null;
        WordExtractor extractor = null;
        try
        {
            file = new File(filePath);
            FileInputStream fis = new FileInputStream(file.getAbsolutePath());
            HWPFDocument document = new HWPFDocument(fis);
            extractor = new WordExtractor(document);
            return extractor.getText().toLowerCase();
        }
        catch (Exception exep)
        {
            exep.printStackTrace();
            return "";
        }
    }
    public boolean checkForShortlisting(String filePath,List<String> keyWordsToSearch){
        String docTxt=readDoc(filePath);
        return keyWordsToSearch.stream()
                .map(String::toLowerCase)
                .anyMatch(docTxt::contains);
    }
}
