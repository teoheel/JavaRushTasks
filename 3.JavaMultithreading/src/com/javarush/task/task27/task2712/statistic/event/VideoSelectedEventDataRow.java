package com.javarush.task.task27.task2712.statistic.event;

import com.javarush.task.task27.task2712.ad.Advertisement;

import java.util.Date;
import java.util.List;

public class VideoSelectedEventDataRow implements EventDataRow {
    private final Date currentDate;
    private final List<Advertisement> optimalVideoSet;
    private final long amount;
    private final int totalDuration;

    public VideoSelectedEventDataRow(List<Advertisement> optimalVideoSet, long amount, int totalDuration) {
        currentDate = new Date();
        this.optimalVideoSet = optimalVideoSet;
        this.amount = amount;
        this.totalDuration = totalDuration;
    }

    public long getAmount() {
        return amount;
    }

    @Override
    public EventType getType() {
        return EventType.SELECTED_VIDEOS;
    }

    @Override
    public Date getDate() {
        return currentDate;
    }

    @Override
    public int getTime() {
        return totalDuration;
    }
}
