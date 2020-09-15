package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.HashBiMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class SpeedTest {
    public long getTimeToGetIds(Shortener shortener, Set<String> strings, Set<Long> ids) {
        long startTime = System.currentTimeMillis();
        strings.forEach(string -> ids.add(shortener.getId(string)));
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public long getTimeToGetStrings(Shortener shortener, Set<Long> ids, Set<String> strings) {
        long startTime = System.currentTimeMillis();
        ids.forEach(id -> strings.add(shortener.getString(id)));
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    @Test
    public void testHashMapStorage() {
        Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
        Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());
        Set<String> origStrings = new HashSet<>();
        for (int i = 0; i < 10000; i++) {
            origStrings.add(Helper.generateRandomString());
        }

        Set<Long> hashMapIds = new HashSet<>();
        long hashMapTimeToGetIds = getTimeToGetIds(shortener1, origStrings, hashMapIds);
        long hashMapTimeToGetStrings = getTimeToGetStrings(shortener1, hashMapIds, new HashSet<>());

        Set<Long> hashBiMapIds = new HashSet<>();
        long hashBiMapTimeToGetIds = getTimeToGetIds(shortener2, origStrings, hashBiMapIds);
        long hashBiMapTimeToGetStrings = getTimeToGetStrings(shortener2, hashBiMapIds, new HashSet<>());

        Assert.assertTrue(hashMapTimeToGetIds > hashBiMapTimeToGetIds);
        Assert.assertEquals(hashMapTimeToGetStrings, hashBiMapTimeToGetStrings, 30);
    }
}
