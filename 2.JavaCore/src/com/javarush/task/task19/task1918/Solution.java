package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        String result, temp;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()))) {
            StringBuilder stringBuilder = new StringBuilder();
            while ((temp = fileReader.readLine()) != null) {
                stringBuilder.append(temp).append("\n");
            }
            result = stringBuilder.toString();
            Document doc = Jsoup.parse(result, "", Parser.xmlParser());
            String s = doc.getElementsByTag(args[0]).outerHtml();
            System.out.println(s);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
