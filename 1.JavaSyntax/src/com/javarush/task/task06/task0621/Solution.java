package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Родственные связи кошек
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String grandpaName = reader.readLine();
        Solution.Cat grandpa = new Solution.Cat(grandpaName);
        String grandmaName = reader.readLine();
        Solution.Cat grandma = new Solution.Cat(grandmaName);
        String dadName = reader.readLine();
        Solution.Cat dad = new Solution.Cat(dadName, grandpa, null);
        String momName = reader.readLine();
        Solution.Cat mom = new Solution.Cat(momName, null, grandma);
        String sName = reader.readLine();
        Solution.Cat son = new Solution.Cat(sName, dad, mom);
        String dName = reader.readLine();
        Solution.Cat daughter = new Solution.Cat(dName, dad, mom);
        System.out.println(grandpa);
        System.out.println(grandma);
        System.out.println(dad);
        System.out.println(mom);
        System.out.println(son);
        System.out.println(daughter);
    }

    public static class Cat {
        private String name;
        private Solution.Cat dad;
        private Solution.Cat mom;

        public Cat(String name) {
            this.name = name;
        }

        public Cat(String name, Solution.Cat dad, Solution.Cat mom) {
            this.name = name;
            this.dad = dad;
            this.mom = mom;
        }

        public String toString() {
            if (this.dad == null && this.mom == null) {
                return "Cat name is " + this.name + ", no mother, no father";
            } else if (this.dad == null) {
                return "Cat name is " + this.name + ", mother is " + this.mom.name + ", no father";
            } else {
                return this.mom == null ? "Cat name is " + this.name + ", no mother, father is " + this.dad.name : "Cat name is " + this.name + ", mother is " + this.mom.name + ", father is " + this.dad.name;
            }
        }
    }
}
