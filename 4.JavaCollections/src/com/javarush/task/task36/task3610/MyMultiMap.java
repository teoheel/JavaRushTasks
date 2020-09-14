package com.javarush.task.task36.task3610;

import java.io.Serializable;
import java.util.*;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID = 123456789L;
    private final HashMap<K, List<V>> map;
    private final int repeatCount;

    public MyMultiMap(int repeatCount) {
        this.repeatCount = repeatCount;
        map = new HashMap<>();
    }

    @Override
    public int size() {
        return values().size();
    }

    @Override
    public V put(K key, V value) {
        List<V> values = map.get(key);
        V oldValue = null;

        if (values == null) {
            values = new ArrayList<>();
        } else {
            oldValue = values.get(values.size() - 1);
            if (values.size() == repeatCount) {
                values.remove(0);
            }
        }

        values.add(value);
        map.put(key, values);
        return oldValue;
    }

    @Override
    @SuppressWarnings("all")
    public V remove(Object key) {
        List<V> values = map.get(key);
        if (values == null) {
            return null;
        }

        V storeValue = values.get(0);
        values.remove(0);

        if (values.size() == 0) {
            map.remove(key);
        }

        return storeValue;
    }

    @Override
    public Set<K> keySet() {
        return map.keySet();
    }

    @Override
    public Collection<V> values() {
        ArrayList<V> list = new ArrayList<>();
        for (List<V> value : map.values()) {
            list.addAll(value);
        }
        return list;
    }

    @Override
    @SuppressWarnings("all")
    public boolean containsKey(Object key) {
        return keySet().contains(key);
    }

    @Override
    @SuppressWarnings("all")
    public boolean containsValue(Object value) {
        return values().contains(value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        map.forEach((key, value) -> {
            sb.append(key);
            sb.append("=");
            for (V v : value) {
                sb.append(v);
                sb.append(", ");
            }
        });
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }
}