package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;

import java.util.ResourceBundle;

import static com.javarush.task.task26.task2613.ConsoleHelper.writeMessage;

class InfoCommand implements Command {
    private final ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "info");

    @Override
    public void execute() {
        writeMessage(res.getString("before"));
        boolean hasMoney = false;
        for (CurrencyManipulator manipulator : CurrencyManipulatorFactory.getAllCurrencyManipulators()) {
            if (manipulator.hasMoney()) {
                hasMoney = true;
                writeMessage("\t" + manipulator.getCurrencyCode() + " - " + manipulator.getTotalAmount());
            }
        }

        if (!hasMoney) {
            writeMessage(res.getString("no.money"));
        }
    }
}
