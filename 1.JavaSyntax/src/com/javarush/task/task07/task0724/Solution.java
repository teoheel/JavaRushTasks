package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human motherGrandmother = new Human("Элли", false, 78);
        Human motherGrandfather = new Human("Билли", true, 76);
        Human fatherGrandmother = new Human("Кристи", false, 82);
        Human fatherGrandfather = new Human("Джонни", true, 85);
        Human mother = new Human("Джилл", false, 50, motherGrandfather, motherGrandmother);
        Human father = new Human("Крэйг", true, 55, fatherGrandfather, fatherGrandmother);
        Human child1 = new Human("Кристиан", true, 26, father, mother);
        Human child2 = new Human("Частити", false, 22, father, mother);
        Human child3 = new Human("Браян", true, 15, father, mother);

        System.out.println(motherGrandmother);
        System.out.println(motherGrandfather);
        System.out.println(fatherGrandmother);
        System.out.println(fatherGrandfather);
        System.out.println(mother);
        System.out.println(father);
        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);
    }

    public static class Human {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        Human father, mother;

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}






















