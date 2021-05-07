package com.javarush.task.task33.task3308;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@XmlRootElement
public class Shop {
    public Goods goods;
    public int count;
    public double profit;
    public String[] secretData;

    @Override
    public String toString() {
        return String.format("goods:%s%s%s%d%s%.2f%s%s", System.lineSeparator(), goods.names, System.lineSeparator(), count, System.lineSeparator(), profit, System.lineSeparator(), Arrays.toString(secretData));
    }

    public static class Goods {
        public List<String> names = new ArrayList<>();
    }
}
