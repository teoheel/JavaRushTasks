package com.javarush.task.task05.task0510;

/* 
Кошкоинициация
*/

public class Cat {
    //напишите тут ваш код
    String name, address, color;
    int age, weight;

    public static void main(String[] args) {
    }

    public void initialize(String name) {
        this.name = name;
        age = 5;
        weight = 10;
        color = "black";
    }

    public void initialize(String name, int weight, int age) {
        this.name = name;
        this.weight = weight;
        this.age = age;
        color = "black";
    }

    public void initialize(String name, int age) {
        this.name = name;
        this.age = age;
        weight = 5;
        color = "black";
    }

    public void initialize(int weight, String color) {
        age = 5;
        this.weight = weight;
        this.color = color;
    }

    public void initialize(int weight, String color, String address) {
        age = 5;
        this.weight = weight;
        this.color = color;
        this.address = address;
    }
}
