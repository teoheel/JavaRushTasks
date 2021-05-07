package com.javarush.task.task03.task0307;

/* 
Привет Starcraft!
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        for (int i = 1; i <= 10; i++) {
            Zerg zerg = new Zerg();
            zerg.name = "zerg" + i;
        }
        for (int j = 1; j <= 5; j++) {
            Protoss protoss = new Protoss();
            protoss.name = "protoss" + j;
        }
        for (int z = 1; z <= 12; z++) {
            Terran terran = new Terran();
            terran.name = "terran" + z;
        }

    }

    public static class Zerg {
        public String name;
    }

    public static class Protoss {
        public String name;
    }

    public static class Terran {
        public String name;
    }
}
