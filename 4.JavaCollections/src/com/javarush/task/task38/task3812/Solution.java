package com.javarush.task.task38.task3812;

/* 
Обработка аннотаций
*/

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(printFullyQualifiedNames(Solution.class));
        System.out.println(printFullyQualifiedNames(SomeTest.class));

        System.out.println(printValues(Solution.class));
        System.out.println(printValues(SomeTest.class));
    }

    public static boolean printFullyQualifiedNames(Class<?> c) {
        if (c.isAnnotationPresent(PrepareMyTest.class)) {
            PrepareMyTest prepareMyTest = c.getAnnotation(PrepareMyTest.class);
            System.out.println(Arrays.toString(prepareMyTest.fullyQualifiedNames()));
            return true;
        } else {
            return false;
        }
    }

    public static boolean printValues(Class<?> c) {
        if (c.isAnnotationPresent(PrepareMyTest.class)) {
            PrepareMyTest prepareMyTest = c.getAnnotation(PrepareMyTest.class);
            System.out.println(Arrays.toString(prepareMyTest.value()));
            return true;
        } else {
            return false;
        }
    }
}
