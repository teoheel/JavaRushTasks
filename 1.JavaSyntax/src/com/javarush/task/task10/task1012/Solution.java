package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();

        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < abcArray.length; i++) {
            alphabet.add(abcArray[i]);
        }

        // ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }


        // напишите тут ваш код
        ArrayList<Character> characterArrayList = new ArrayList<>();
        for (String string : list) {
            char[] chars = string.toCharArray();
            for (Character character : chars) {
                characterArrayList.add(character);
            }
        }

        for (Character character : alphabet) {
            int count = 0;
            for (Character character1 : characterArrayList) {
                if (character.equals(character1)) {
                    count++;
                }
            }
            System.out.println(character + " " + count);
        }
    }

}
