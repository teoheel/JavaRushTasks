package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

public class AdvertisementStorage {
    private static volatile AdvertisementStorage singleton;

    private final List<Advertisement> videos = new ArrayList<>();

    private AdvertisementStorage() {
        Object someContent = new Object();
        add(new Advertisement(someContent, "First Video", 5000, 100, 3 * 60));
        add(new Advertisement(someContent, "Second Video", 100, 10, 15 * 60));
        add(new Advertisement(someContent, "Third Video", 400, 2, 10 * 60));
        add(new Advertisement(someContent, "четвёртое видео", 800, 4, 5 * 60));
    }

    public static AdvertisementStorage getInstance() {
        if (singleton == null) {
            synchronized (AdvertisementStorage.class) {
                if (singleton == null) {
                    singleton = new AdvertisementStorage();
                }
            }
        }
        return singleton;
    }

    public void add(Advertisement advertisement) {
        videos.add(advertisement);
    }

    public List<Advertisement> list() {
        return videos;
    }
}