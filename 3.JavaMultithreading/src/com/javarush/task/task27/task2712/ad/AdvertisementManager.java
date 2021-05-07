package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.javarush.task.task27.task2712.ConsoleHelper.writeMessage;

public class AdvertisementManager {
    private final StatisticManager statisticManager = StatisticManager.getInstance();
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();

    private final int timeSeconds;
    private List<Advertisement> bestAdvertisements;
    private long bestAmount;
    private int bestDuration;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() throws NoVideoAvailableException {
        if (storage.list().isEmpty()) {
            throw new NoVideoAvailableException();
        }
        List<Advertisement> advertisements = storage.list().stream()
                .filter(advertisement -> advertisement.getHits() > 0)
                .collect(Collectors.toList());
        makeAllAdvertisements(advertisements);
        if (bestAdvertisements != null) {
            bestAdvertisements
                    .sort(Comparator.comparingLong(Advertisement::getAmountPerOneDisplaying)
                            .thenComparingLong(Advertisement::getAmountPerOneSecondOfDisplaying).reversed());
            bestAdvertisements.forEach(advertisement -> {
                writeMessage(advertisement.toString());
                advertisement.revalidate();
            });
            statisticManager.register(new VideoSelectedEventDataRow(bestAdvertisements, bestAmount, bestDuration));
        }
    }

    private int calcDuration(List<Advertisement> advertisements) {
        return advertisements.stream().mapToInt(Advertisement::getDuration).sum();
    }

    private long calcAmount(List<Advertisement> advertisements) {
        return advertisements.stream().mapToLong(Advertisement::getAmountPerOneDisplaying).sum();
    }

    private void checkSet(List<Advertisement> advertisements) {
        if (bestAdvertisements == null) {
            if (calcDuration(advertisements) <= timeSeconds) {
                bestAdvertisements = advertisements;
                bestAmount = calcAmount(advertisements);
                bestDuration = calcDuration(advertisements);
            }
        } else {
            if (calcDuration(advertisements) <= timeSeconds && calcAmount(advertisements) > bestAmount) {
                bestAdvertisements = advertisements;
                bestAmount = calcAmount(advertisements);
                bestDuration = calcDuration(advertisements);
            }
        }
    }

    private void makeAllAdvertisements(List<Advertisement> advertisements) {
        if (advertisements.size() > 0) {
            checkSet(advertisements);
        }
        for (int i = advertisements.size() - 1; i >= 0; i--) {
            List<Advertisement> newAdvertisements = new ArrayList<>(advertisements);
            newAdvertisements.remove(i);
            makeAllAdvertisements(newAdvertisements);
        }
    }
}