package com.javarush.task.task35.task3505;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ConvertableUtil {
    public static <K, V extends Convertable<?>> Map<K, V> convert(List<V> list) {
        return list.stream().collect(Collectors.toMap(key -> (K) key.getKey(), Function.identity()));
    }
}
