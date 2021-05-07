package com.javarush.task.task14.task1408;

/* 
Куриная фабрика
*/

public class Solution {
    public static void main(String[] args) {
        Hen hen = HenFactory.getHen(Country.BELARUS);
        hen.getCountOfEggsPerMonth();
    }

    static class HenFactory {

        static Hen getHen(String country) {
            Hen hen = null;
            //напишите тут ваш код
            if (country == Country.BELARUS) {
                hen = new BelarusianHen();
            }
            if (country == Country.MOLDOVA) {
                hen = new MoldovanHen();
            }
            if (country == Country.RUSSIA) {
                hen = new RussianHen();
            }
            if (country == Country.UKRAINE) {
                hen = new UkrainianHen();
            }
            return hen;
        }
    }


}
