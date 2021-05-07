package com.javarush.task.task28.task2801;

/* 
Осваиваем switch
*/
public class Solution {
    public static void main(String[] args) {
        Solution.switchTest(E1.C);
        Solution.switchTest(E3.D);
        Solution.switchTest(E2.D);
        /* output
        it's E1.C
        undefined
        it's E2.D
         */
    }

    public static void switchTest(Enum obj) {
        //add your code here
        String enumName = obj.getClass().getSimpleName();
        String value = obj.toString();
        switch (enumName) {
            case "E1":
            case "E2":
                System.out.printf("it's %s.%s" + System.lineSeparator(), enumName, value);
                break;
            default:
                System.out.println("undefined");
        }
    }

    public enum E1 {A, B, C, Y}

    public enum E2 {D, E, F}

    public enum E3 {D, E, F}
}
