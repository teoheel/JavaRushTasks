package com.javarush.task.task14.task1409;

/* 
Мосты
*/

public class Solution {
    public static void main(String[] args) {
        println(new WaterBridge());
        println(new SuspensionBridge());
    }

    //add println method here
    public static void println(Bridge bridge) {
        if (bridge instanceof WaterBridge) {
            System.out.println(((WaterBridge) bridge).getCarsCount());
        } else if (bridge instanceof SuspensionBridge) {
            System.out.println(((SuspensionBridge) bridge).getCarsCount());
        }
    }
}

