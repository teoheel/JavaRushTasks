package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.List;
import java.util.Map;

import static com.javarush.task.task27.task2712.ConsoleHelper.writeMessage;

public class DirectorTablet {

    private final StatisticManager statisticManager = StatisticManager.getInstance();
    private final StatisticAdvertisementManager statisticAdvertisementManager = StatisticAdvertisementManager.getInstance();

    public void printAdvertisementProfit() {
        Map<String, Double> printableMap = statisticManager.getAdvertisementProfit();
        double profitAmount = 0;
        for (Map.Entry<String, Double> advertisementProfit : printableMap.entrySet()) {
            profitAmount += advertisementProfit.getValue();
            String profit = String.format("%s - %.2f", advertisementProfit.getKey(), advertisementProfit.getValue()).replace(",", ".");
            writeMessage(profit);
        }
        String profit = String.format("Total - %.2f", profitAmount).replace(",", ".");
        writeMessage(profit);
    }

    public void printCookWorkloading() {
        Map<String, Map<String, Integer>> cookWorkloading = statisticManager.getCookWorkloading();

        for (Map.Entry<String, Map<String, Integer>> cookWorkload : cookWorkloading.entrySet()) {
            String date = cookWorkload.getKey();
            writeMessage(date);
            for (Map.Entry<String, Integer> cook : cookWorkload.getValue().entrySet()) {
                String cookName = cook.getKey();
                int cookingTime = cook.getValue();
                String workload = String.format("%s - %d min", cookName, cookingTime);
                writeMessage(workload);
            }
        }
    }


    public void printActiveVideoSet() {
        Map<String, Integer> activeVideoSet = statisticAdvertisementManager.getActiveVideoSet();

        for (Map.Entry<String, Integer> video : activeVideoSet.entrySet()) {
            String videoName = video.getKey();
            int hits = video.getValue();
            writeMessage(String.format("%s - %d", videoName, hits));
        }
    }

    public void printArchivedVideoSet() {
        List<String> archivedVideoSet = statisticAdvertisementManager.getArchivedVideoSet();
        archivedVideoSet.sort(String::compareToIgnoreCase);

        for (String videoName : archivedVideoSet) {
            writeMessage(videoName);
        }
    }
}
