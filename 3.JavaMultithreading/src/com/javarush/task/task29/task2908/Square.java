package com.javarush.task.task29.task2908;

public class Square implements Computable<Integer, Integer> {
    @Override
    public Integer compute(Integer integer) {
        int val = integer;
        return val * val;
    }
}
