package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static {
        labels.put(0D, "Zero");
        labels.put(1D, "One");
        labels.put(2D, "Two");
        labels.put(3D, "Three");
        labels.put(4D, "Four");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
