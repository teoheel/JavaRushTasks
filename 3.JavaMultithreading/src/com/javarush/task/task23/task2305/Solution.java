package com.javarush.task.task23.task2305;

/* 
Inner
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public static Solution[] getTwoSolutions() {
        Solution[] solutions = new Solution[2];
        for (int i = 0; i < solutions.length; i++) {
            solutions[i] = new Solution();
            for (int j = 0; j < solutions[i].innerClasses.length; j++) {
                solutions[i].innerClasses[j] = solutions[i].new InnerClass();
            }
        }
        return solutions;
    }

    public static void main(String[] args) {

    }

    public class InnerClass {
    }
}
