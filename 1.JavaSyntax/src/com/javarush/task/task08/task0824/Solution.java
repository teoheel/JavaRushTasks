package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human fatherGrandfather = new Human("Alex", true, 86);
        Human fatherGrandmother = new Human("Elly", false, 88);
        Human motherGrandfather = new Human("Brad", true, 89);
        Human motherGrandmother = new Human("Lexie", false, 87);
        Human father = new Human("Steve", true, 57);
        fatherGrandfather.children.add(father);
        fatherGrandmother.children.add(father);
        Human mother = new Human("Alexis", false, 56);
        motherGrandfather.children.add(mother);
        motherGrandmother.children.add(mother);
        Human child1 = new Human("Curtis", true, 35);
        father.children.add(child1);
        mother.children.add(child1);
        Human child2 = new Human("Kathy", false, 30);
        father.children.add(child2);
        mother.children.add(child2);
        Human child3 = new Human("Charlotte", false, 26);
        father.children.add(child3);
        mother.children.add(child3);

        ArrayList<Human> humans = new ArrayList<>();
        humans.add(fatherGrandfather);
        humans.add(fatherGrandmother);
        humans.add(motherGrandfather);
        humans.add(motherGrandmother);
        humans.add(father);
        humans.add(mother);
        humans.add(child1);
        humans.add(child2);
        humans.add(child3);
        for (Human human : humans) {
            System.out.println(human);
        }
    }

    public static class Human {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<>();

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
