package com.javarush.task.task27.task2712.ad;

public class Advertisement {
    private final Object content;
    private final String name;
    private final long initialAmount, amountPerOneDisplaying, amountPerOneSecondOfDisplaying;
    private final int duration;
    private int hits;

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        amountPerOneDisplaying = this.hits > 0 ? this.initialAmount / this.hits : 0;
        amountPerOneSecondOfDisplaying = amountPerOneDisplaying * 1000 / this.duration;
    }

    public long getAmountPerOneSecondOfDisplaying() {
        return amountPerOneSecondOfDisplaying;
    }

    public int getHits() {
        return hits;
    }

    public String getName() {
        return name;
    }

    public long getAmountPerOneDisplaying() {
        return amountPerOneDisplaying;
    }

    public int getDuration() {
        return duration;
    }

    public void revalidate() throws UnsupportedOperationException {
        if (hits-- <= 0) {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public String toString() {
        return String.format("%s is displaying... %d, %d", name, amountPerOneDisplaying, amountPerOneSecondOfDisplaying);
    }
}
