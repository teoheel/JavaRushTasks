package com.javarush.task.task26.task2613.command;


import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.ResourceBundle;

import static com.javarush.task.task26.task2613.ConsoleHelper.readString;
import static com.javarush.task.task26.task2613.ConsoleHelper.writeMessage;

class ExitCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.class.getPackage().getName() + ".resources.exit");

    @Override
    public void execute() throws InterruptOperationException {
        writeMessage(res.getString("exit.question.y.n"));
        String result = readString();
        if (result != null && "y".equals(result.toLowerCase())) {
            writeMessage(res.getString("thank.message"));
        } else {
            //TODO process NO
        }
    }
}
