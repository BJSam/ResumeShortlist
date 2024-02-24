package org.example;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadWordFile {
    private String readDoc(String filePath){
        File file;
        WordExtractor extractor;
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
            System.out.println("Error"+exep.getMessage());
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
            System.out.println("Error"+e.getMessage());
        }
        return extractedText;
    }
    public double findPercentageMatched(String filePath,List<String> keyWordsToSearch, boolean isDocx){
        String resumeData;
        int matchedWords = 0;
        if(isDocx){
            resumeData=readDocx(filePath);
        }else{
            resumeData=readDoc(filePath);
        }
        for(String keyWord: keyWordsToSearch){
            Pattern pattern = Pattern.compile("\\b"+ keyWord + "\\b", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(resumeData);
            if (matcher.find()){
                matchedWords++;
            }
        }
        return (double) matchedWords /keyWordsToSearch.size() * 100;
    }
}
