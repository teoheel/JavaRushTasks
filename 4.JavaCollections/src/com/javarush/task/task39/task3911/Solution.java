package com.javarush.task.task39.task3911;

import java.util.Map;

/* 
Rollback
*/

public class Solution {
    public static void main(String[] args) {
        Software software = new Software();
        int n = 3;
        for (int i = 1; i <= 6; i++) {
            software.addNewVersion(i, "Description of version #" + i);
        }

        printAllVersions(software);

        System.out.printf("%sROLLING BACK to version %d%1$s", System.lineSeparator(), n);
        System.out.printf("Was rollback done? %b%s%2$s", software.rollback(n), System.lineSeparator());

        printAllVersions(software);
    }

    private static void printAllVersions(Software software) {
        System.out.println("Printing all versions:");
        for (Map.Entry<Integer, String> entry : software.getVersionHistoryMap().entrySet()) {
            System.out.println(entry.getKey() + " :: " + entry.getValue());
        }
        System.out.println("The current version is " + software.getCurrentVersion());
    }
}
