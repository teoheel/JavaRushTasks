package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.text.SimpleDateFormat;
import java.util.*;

public class StatisticManager {
    private static volatile StatisticManager singleton;
    private final StatisticStorage statisticStorage = new StatisticStorage();
    private final Map<EventType, List<EventDataRow>> storage = statisticStorage.getStorage();

    private StatisticManager() {
    }

    public static StatisticManager getInstance() {
        if (singleton == null) {
            synchronized (StatisticManager.class) {
                if (singleton == null) {
                    singleton = new StatisticManager();
                }
            }
        }
        return singleton;
    }

    public Map<String, Double> getAdvertisementProfit() {
        Map<String, Double> advertisementProfit = new TreeMap<>(Collections.reverseOrder());
        SimpleDateFormat sDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        List<EventDataRow> list = storage.get(EventType.SELECTED_VIDEOS);

        for (EventDataRow eventDataRow : list) {
            VideoSelectedEventDataRow videoSelectedEventDataRow = (VideoSelectedEventDataRow) eventDataRow;
            String date = sDateFormat.format(videoSelectedEventDataRow.getDate());
            double amount = (double) videoSelectedEventDataRow.getAmount() / 100;

            if (advertisementProfit.containsKey(date)) {
                advertisementProfit.put(date, advertisementProfit.get(date) + amount);
            } else {
                advertisementProfit.put(date, amount);
            }
        }
        return advertisementProfit;
    }

    public Map<String, Map<String, Integer>> getCookWorkloading() {
        Map<String, Map<String, Integer>> result = new TreeMap<>(Collections.reverseOrder());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        List<EventDataRow> list = storage.get(EventType.COOKED_ORDER);

        for (EventDataRow eventDataRow : list) {
            CookedOrderEventDataRow cookedOrderEventDataRow = (CookedOrderEventDataRow) eventDataRow;
            String date = simpleDateFormat.format(cookedOrderEventDataRow.getDate());
            String cookName = cookedOrderEventDataRow.getCookName();
            int cookingTime = cookedOrderEventDataRow.getTime();

            if (result.containsKey(date)) {
                Map<String, Integer> temp = result.get(date);
                if (temp.containsKey(cookName)) temp.put(cookName, temp.get(cookName) + cookingTime);
                else temp.put(cookName, cookingTime);
                result.put(date, temp);
            } else {
                Map<String, Integer> temp = new TreeMap<>();
                temp.put(cookName, cookingTime);
                result.put(date, temp);
            }
        }
        return result;
    }

    public void register(EventDataRow data) {
        statisticStorage.put(data);
    }

    private static class StatisticStorage {
        private final Map<EventType, List<EventDataRow>> storage;

        StatisticStorage() {
            storage = new LinkedHashMap<>();
            for (EventType eventType : EventType.values()) {
                storage.put(eventType, new ArrayList<>());
            }
        }

        private void put(EventDataRow data) {
            storage.get(data.getType()).add(data);
        }

        public Map<EventType, List<EventDataRow>> getStorage() {
            return storage;
        }
    }
}