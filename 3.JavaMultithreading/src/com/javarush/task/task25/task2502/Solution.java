package com.javarush.task.task25.task2502;

import java.util.ArrayList;
import java.util.List;

/* 
Машину на СТО не повезем!
*/
public class Solution {
    public static void main(String[] args) {
        for (Wheel wheel : new Car().wheels) {
            System.out.println(wheel);
        }
    }

    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() {
            //init wheels here
            wheels = new ArrayList<>();
            for (String wheel : loadWheelNamesFromDB()) {
                wheels.add(Wheel.valueOf(wheel));
            }
            if (loadWheelNamesFromDB().length != Wheel.values().length) {
                throw new IllegalArgumentException();
            }
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }
}
