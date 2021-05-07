package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/*
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    Entry<String> root;
    List<Entry<String>> list = new ArrayList<>();

    public CustomTree() {
        root = new Entry<>("0");
        list.add(root);
    }

    @Override
    public boolean remove(Object o) {
        if (!(o instanceof String)) {
            throw new UnsupportedOperationException();
        }

        String remove = (String) o;
        Entry<String> removed = null;

        for (Entry<String> entry : list) {
            if (entry.elementName.equals(remove)) {
                removed = entry;
                break;
            }
        }

        if (removed == null)
            return false;

        if (removed.leftChild != null)
            remove(removed.leftChild.elementName);

        if (removed.rightChild != null)
            remove(removed.rightChild.elementName);

        if (removed.parent.leftChild == removed)
            removed.parent.leftChild = null;
        else
            removed.parent.rightChild = null;
        list.remove(removed);

        return true;
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        return list.size() - 1;
    }

    @Override
    public boolean add(String s) {
        Queue<Entry<String>> queue = new LinkedList<>();
        queue.add(root);
        Entry<String> current = new Entry<>(s);
        list.add(current);

        while (!queue.isEmpty()) {
            Entry<String> knot = queue.remove();

            if (knot.leftChild == null && knot.rightChild == null) {
                knot.availableToAddLeftChildren = true;
                knot.availableToAddRightChildren = true;
            }
            if (knot.availableToAddLeftChildren) {
                knot.leftChild = current;
                current.parent = knot;
                knot.availableToAddLeftChildren = false;
                return true;
            } else {
                if (knot.leftChild != null)
                    queue.add(knot.leftChild);
            }

            if (knot.availableToAddRightChildren) {
                knot.rightChild = current;
                current.parent = knot;
                knot.availableToAddRightChildren = false;
                return true;
            } else {
                if (knot.rightChild != null)
                    queue.add(knot.rightChild);
            }
        }

        return false;
    }

    public String getParent(String s) {
        for (Entry<String> item : list) {
            if (item.elementName.equals(s))
                return item.parent.elementName;
        }
        return null;
    }

    static class Entry<T> implements Serializable {
        String elementName;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }
    }
}
