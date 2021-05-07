package com.javarush.task.task36.task3601;

public class View {
    private static final Controller CONTROLLER = new Controller();

    public void fireShowDataEvent() {
        System.out.println(CONTROLLER.onShowDataList());
    }
}
