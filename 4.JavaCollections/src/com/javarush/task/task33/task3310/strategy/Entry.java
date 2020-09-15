package com.javarush.task.task33.task3310.strategy;

import java.io.Serializable;
import java.util.Objects;

public class Entry implements Serializable {
    final int hash;
    final Long key;
    String value;
    Entry next;

    public Entry(int hash, Long key, String value, Entry next) {
        this.hash = hash;
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public final Long getKey() {
        return key;
    }

    public final String getValue() {
        return value;
    }

    @Override
    public final String toString() {
        return getKey() + "=" + getValue();
    }

    @Override
    public final int hashCode() {
        return (key == null ? 0 : key.hashCode()) ^
                (value == null ? 0 : value.hashCode());
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Entry))
            return false;
        Entry e = (Entry) o;
        Object k1 = getKey();
        Object k2 = e.getKey();
        if (Objects.equals(k1, k2)) {
            Object v1 = getValue();
            Object v2 = e.getValue();
            return Objects.equals(v1, v2);
        }
        return false;
    }
}
