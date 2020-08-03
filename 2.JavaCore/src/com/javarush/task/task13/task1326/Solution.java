package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException, NumberFormatException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // Сюда считываем имя файла
        BufferedReader fileReader;

        // Сюда записываем файл
        while (true) {
            try {
                fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(reader.readLine())));
                break;
            } catch (IOException e) {
            }
        }

        reader.close(); // закрываем считыватель для имени файла

        ArrayList<Integer> evenIntegers = new ArrayList<>(); // создаём упорядоченный список для чётных чисел

        // добавляем чётные числа из потока
        while (fileReader.ready()) {
            try {
                Integer i = Integer.parseInt(fileReader.readLine());
                if (i % 2 == 0) {
                    evenIntegers.add(i);
                }
            } catch (NumberFormatException e) {
            }
        }

        fileReader.close(); // закрываем поток с данными из файла

        // сортируем по возрастанию список чётных чисел
        for (int i = evenIntegers.size() - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (evenIntegers.get(j) > evenIntegers.get(j + 1)) {
                    Integer number = evenIntegers.get(j);
                    evenIntegers.set(j, evenIntegers.get(j + 1));
                    evenIntegers.set(j + 1, number);
                }
            }
        }

        // выводим отсортированный список
        for (Integer integer : evenIntegers) {
            System.out.println(integer);
        }
    }
}
