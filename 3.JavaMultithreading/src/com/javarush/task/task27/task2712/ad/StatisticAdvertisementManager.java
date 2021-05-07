package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class StatisticAdvertisementManager {

    private static volatile StatisticAdvertisementManager singleton;
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();

    private StatisticAdvertisementManager() {
    }

    public static StatisticAdvertisementManager getInstance() {
        if (singleton == null) {
            synchronized (StatisticAdvertisementManager.class) {
                if (singleton == null) {
                    singleton = new StatisticAdvertisementManager();
                }
            }
        }
        return singleton;
    }

    public Map<String, Integer> getActiveVideoSet() {
        Map<String, Integer> activeVideoSet = new TreeMap<>(String::compareToIgnoreCase);
        List<Advertisement> advertisements = storage.list();
        for (Advertisement advertisement : advertisements) {
            String name = advertisement.getName();
            int hits = advertisement.getHits();
            if (hits > 0) {
                activeVideoSet.put(name, hits);
            }
        }
        return activeVideoSet;
    }

    public List<String> getArchivedVideoSet() {
        List<String> archivedVideoSet = new ArrayList<>();
        List<Advertisement> advertisements = storage.list();
        for (Advertisement advertisement : advertisements) {
            String name = advertisement.getName();
            int hits = advertisement.getHits();
            if (hits <= 0) {
                archivedVideoSet.add(name);
            }
        }
        return archivedVideoSet;
    }
}