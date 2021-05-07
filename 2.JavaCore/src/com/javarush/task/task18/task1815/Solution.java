package com.javarush.task.task18.task1815;

import java.util.List;

/* 
Таблица
*/

public class Solution {
    public static void main(String[] args) {
    }

    public interface TableInterface {
        void setModel(List rows);

        String getHeaderText();

        void setHeaderText(String newHeaderText);
    }

    public class TableInterfaceWrapper implements TableInterface {
        TableInterface tableInterface;
        String headerText;

        public TableInterfaceWrapper(TableInterface tableInterface) {
            this.tableInterface = tableInterface;
        }

        @Override
        public void setModel(List rows) {
            System.out.println(rows.size());
            tableInterface.setModel(rows);
        }

        @Override
        public String getHeaderText() {
            return tableInterface.getHeaderText().toUpperCase();
        }

        @Override
        public void setHeaderText(String headerText) {
            tableInterface.setHeaderText(headerText);
        }
    }
}