package com.javarush.task.task35.task3510;

import java.util.ArrayList;
import java.util.List;

/* 
Вход воспрещен!
*/
public class House<T> {
    private final List<T> RESIDENTS = new ArrayList<>();

    public void enter(T resident) {
        RESIDENTS.add(resident);
    }

    public void leave(T resident) {
        RESIDENTS.remove(resident);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("В доме находятся:\n");
        for (Object resident : RESIDENTS) {
            builder.append(resident.toString()).append("\n");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Dog bruno = new Dog("Bruno");
        Puppy larsik = new Puppy("Larsik");
        Cat barsik = new Cat("Barsik");
        Kitten keksik = new Kitten("Keksik");

        House<Dog> dogHouse = new House<>();
        dogHouse.enter(bruno);
        dogHouse.enter(larsik);
        System.out.println(dogHouse.toString());

        House<Cat> catHouse = new House<>();
        catHouse.enter(barsik);
        catHouse.enter(keksik);
        System.out.println(catHouse.toString());
    }
}
