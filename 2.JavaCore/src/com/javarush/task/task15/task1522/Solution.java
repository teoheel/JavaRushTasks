package com.javarush.task.task15.task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Закрепляем паттерн Singleton
*/

public class Solution {
    public static Planet thePlanet;

    //add static block here - добавьте статический блок тут
    static {
        readKeyFromConsoleAndInitPlanet();
    }

    public static void main(String[] args) {

    }

    public static void readKeyFromConsoleAndInitPlanet() {
        // implement step #5 here - реализуйте задание №5 тут
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String planet = reader.readLine();
            if (planet.equals(Planet.EARTH)) {
                thePlanet = Earth.getInstance();
            } else if (planet.equals(Planet.MOON)) {
                thePlanet = Moon.getInstance();
            } else if (planet.equals(Planet.SUN)) {
                thePlanet = Sun.getInstance();
            } else thePlanet = null;
            reader.close();
        } catch (IOException e) {

        }
    }
}