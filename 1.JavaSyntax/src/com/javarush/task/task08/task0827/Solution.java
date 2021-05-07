package com.javarush.task.task08.task0827;

import java.util.Date;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(isDateOdd("JANUARY 1 2000"));
    }

    public static boolean isDateOdd(String date) {
        Date time = new Date(date);
        Date yearStartTime = new Date(date);
        yearStartTime.setHours(0);
        yearStartTime.setMinutes(0);
        yearStartTime.setSeconds(0);

        yearStartTime.setDate(1);
        yearStartTime.setMonth(0);

        long msTimeDistance = time.getTime() - yearStartTime.getTime();
        long dayMs = 24 * 60 * 60 * 1000;
        int dayCount = (int) (msTimeDistance / dayMs);
        return (dayCount % 2 == 0);
    }
}
