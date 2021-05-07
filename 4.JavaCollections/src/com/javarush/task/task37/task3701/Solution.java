package com.javarush.task.task37.task3701;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;

/* 
Круговой итератор
*/
public class Solution<T> extends ArrayList<T> {
    public static void main(String[] args) {
        Solution<Integer> list = new Solution<>();
        list.add(1);
        list.add(2);
        list.add(3);

        int count = 0;
        for (Integer i : list) {
            //1 2 3 1 2 3 1 2 3 1
            System.out.print(i + " ");
            count++;
            if (count == 10) {
                break;
            }
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new RoundIterator(super.iterator());
    }

    public class RoundIterator implements Iterator<T> {
        Iterator<T> itr;

        public RoundIterator(Iterator<T> itr) {
            this.itr = itr;
        }

        @Override
        public boolean hasNext() {
            return size() > 0;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                return null;
            }
            if (!itr.hasNext()) {
                itr = Solution.super.iterator();
            }
            return itr.next();
        }

        @Override
        public void remove() {
            itr.remove();
        }

        @Override
        public void forEachRemaining(Consumer<? super T> action) {
            itr.forEachRemaining(action);
        }
    }
}
