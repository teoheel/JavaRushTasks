package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // напишите тут ваши переменные и конструкторы
        private String name;
        private int age;
        private boolean sex;
        private int yearsOfExperience;
        private String profession;
        private int countOfWorks;

        public Human() {
            name = "Bill";
            age = 30;
            sex = true;
            yearsOfExperience = 5;
            profession = "Programmer";
            countOfWorks = 1;
        }

        public Human(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Human(String name, int age, boolean sex) {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }

        public Human(String name, int age, boolean sex, int yearsOfExperience) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.yearsOfExperience = yearsOfExperience;
        }

        public Human(String name, int age, boolean sex, int yearsOfExperience, String profession) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.yearsOfExperience = yearsOfExperience;
            this.profession = profession;
        }

        public Human(String name, int age, boolean sex, int yearsOfExperience, String profession, int countOfWorks) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.yearsOfExperience = yearsOfExperience;
            this.profession = profession;
            this.countOfWorks = countOfWorks;
        }

        public Human(String name, int age, boolean sex, int yearsOfExperience, int countOfWorks) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.yearsOfExperience = yearsOfExperience;
            this.countOfWorks = countOfWorks;
        }

        public Human(String name, int yearsOfExperience, String profession, int countOfWorks) {
            this.name = name;
            this.yearsOfExperience = yearsOfExperience;
            this.profession = profession;
            this.countOfWorks = countOfWorks;
        }

        public Human(String name, int yearsOfExperience, String profession) {
            this.name = name;
            this.yearsOfExperience = yearsOfExperience;
            this.profession = profession;
        }

        public Human(String name, int yearsOfExperience, int countOfWorks) {
            this.name = name;
            this.yearsOfExperience = yearsOfExperience;
            this.countOfWorks = countOfWorks;
        }
    }
}
