package com.javarush.task.task14.task1417;

import java.util.ArrayList;
import java.util.List;

/* 
Валюты
*/

public class Solution {
    public static void main(String[] args) {
        Person ivan = new Person("Иван");
        for (Money money : ivan.getAllMoney()) {
            System.out.println(ivan.name + " имеет заначку в размере " + money.getAmount() + " " + money.getCurrencyName());
        }
    }

    static class Person {
        public String name;
        private List<Money> allMoney;

        Person(String name) {
            this.name = name;
            this.allMoney = new ArrayList<Money>();
            //напишите тут ваш код
            Money hrn = new Hrivna(15);
            allMoney.add(hrn);
            Money rub = new Ruble(60);
            allMoney.add(rub);
            Money usd = new USD(1);
            allMoney.add(usd);
        }

        public List<Money> getAllMoney() {
            return allMoney;
        }
    }
}
