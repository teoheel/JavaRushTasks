package com.javarush.task.task27.task2712.statistic.event;

import java.util.Date;

public class NoAvailableVideoEventDataRow implements EventDataRow {
    private final Date currentDate;
    private final int totalDuration;

    public NoAvailableVideoEventDataRow(int totalDuration) {
        currentDate = new Date();
        this.totalDuration = totalDuration;
    }

    @Override
    public EventType getType() {
        return EventType.NO_AVAILABLE_VIDEO;
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
