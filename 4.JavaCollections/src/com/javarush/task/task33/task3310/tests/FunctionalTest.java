package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.*;
import org.junit.Assert;
import org.junit.Test;

public class FunctionalTest {
    @Test
    public void testHashMapStorageStrategy() {
        Shortener shortener = new Shortener(new HashMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testOurHashMapStorageStrategy() {
        Shortener shortener = new Shortener(new OurHashMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testFileStorageStrategy() {
        Shortener shortener = new Shortener(new FileStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testHashBiMapStorageStrategy() {
        Shortener shortener = new Shortener(new HashBiMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testDualHashBidiMapStorageStrategy() {
        Shortener shortener = new Shortener(new DualHashBidiMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testOurHashBiMapStorageStrategy() {
        Shortener shortener = new Shortener(new OurHashBiMapStorageStrategy());
        testStorage(shortener);
    }

    public void testStorage(Shortener shortener) {
        String string1 = "Тестовая строка";
        String string2 = "Тестовая строчка";
        String string3 = "Тестовая строка";

        Long string1Id = shortener.getId(string1);
        Long string2Id = shortener.getId(string2);
        Long string3Id = shortener.getId(string3);

        Assert.assertNotEquals(string1Id, string2Id);
        Assert.assertNotEquals(string3Id, string2Id);

        Assert.assertEquals(string1Id, string3Id);

        String stringOut1 = shortener.getString(string1Id);
        String stringOut2 = shortener.getString(string2Id);
        String stringOut3 = shortener.getString(string3Id);

        Assert.assertEquals(string1, stringOut1);
        Assert.assertEquals(string2, stringOut2);
        Assert.assertEquals(string3, stringOut3);
    }
}
