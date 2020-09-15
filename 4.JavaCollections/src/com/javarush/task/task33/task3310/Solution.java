package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        testStrategy(new HashMapStorageStrategy(), 10000);
        testStrategy(new OurHashMapStorageStrategy(), 10000);
        testStrategy(new FileStorageStrategy(), 100);
        testStrategy(new OurHashBiMapStorageStrategy(), 10000);
        testStrategy(new HashBiMapStorageStrategy(), 10000);
        testStrategy(new DualHashBidiMapStorageStrategy(), 10000);
    }

    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        return strings.stream().map(shortener::getId).collect(Collectors.toSet());
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        return keys.stream().map(shortener::getString).collect(Collectors.toSet());
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        Helper.printMessage(strategy.getClass().getSimpleName());
        Set<String> strings = new HashSet<>();
        for (int i = 0; i < elementsNumber; i++) {
            strings.add(Helper.generateRandomString());
        }
        Shortener shortener = new Shortener(strategy);
        Date getIdsStartDate = new Date();
        Set<Long> ids = getIds(shortener, strings);
        Date getIdsEndDate = new Date();
        long timeToGetIds = getIdsEndDate.getTime() - getIdsStartDate.getTime();
        Helper.printMessage("Time to get ids: " + timeToGetIds + " ms");
        Date getStringsStartDate = new Date();
        Set<String> stringsSet = getStrings(shortener, ids);
        Date getStringsEndDate = new Date();
        long timeToGetStrings = getStringsEndDate.getTime() - getStringsStartDate.getTime();
        Helper.printMessage("Time to get strings: " + timeToGetStrings + " ms");
        Helper.printMessage(stringsSet.equals(strings) ? "Тест пройден." : "Тест не пройден.");
    }
}
