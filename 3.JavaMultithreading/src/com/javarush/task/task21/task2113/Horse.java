package com.javarush.task.task21.task2113;

import java.util.Arrays;

public class Horse {
    private String name;
    private double speed, distance;

    public Horse(String name, double speed, double distance) {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    public void move() {
        setDistance(getDistance() + getSpeed() * Math.random());
    }

    public void print() {
        char[] result = new char[(int) distance];
        Arrays.fill(result, '.');
        System.out.println(new String(result) + getName());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
