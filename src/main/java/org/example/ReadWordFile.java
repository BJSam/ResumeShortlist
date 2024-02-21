package org.example;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

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
            fis.close();
            return extractor.getText().toLowerCase();
        }
        catch (Exception exep)
        {
            exep.printStackTrace();
            return "";
        }
    }
    public String readDocx(String filePath) {
        String extractedText = "";
        try {
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file.getAbsolutePath());
            XWPFDocument document = new XWPFDocument(fis);
            XWPFWordExtractor ex = new XWPFWordExtractor(document);
            extractedText = ex.getText();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return extractedText;
    }
    public boolean checkForShortlisting(String filePath,List<String> keyWordsToSearch, boolean isDocx){
        if(isDocx){
            String docxTxt=readDocx(filePath);
            return keyWordsToSearch.stream()
                    .map(String::toLowerCase)
                    .anyMatch(docxTxt::contains);
        }else{
            String docTxt=readDoc(filePath);
            return keyWordsToSearch.stream()
                    .map(String::toLowerCase)
                    .anyMatch(docTxt::contains);
        }
    }
}
