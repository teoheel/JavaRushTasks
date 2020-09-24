package com.javarush.task.task26.task2613.command;


import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;
import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.Map;
import java.util.ResourceBundle;

import static com.javarush.task.task26.task2613.ConsoleHelper.*;

class WithdrawCommand implements Command {
    private final ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "withdraw");

    @Override
    public void execute() throws InterruptOperationException {
        writeMessage(res.getString("before"));

        String currencyCode = askCurrencyCode();
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);

        while (true) {
            try {
                writeMessage(res.getString("specify.amount"));
                String s = readString();
                if (s == null) {
                    writeMessage(res.getString("specify.not.empty.amount"));
                } else {
                    try {
                        int amount = Integer.parseInt(s);
                        boolean isAmountAvailable = manipulator.isAmountAvailable(amount);
                        if (isAmountAvailable) {
                            Map<Integer, Integer> denominations = manipulator.withdrawAmount(amount);
                            for (Integer item : denominations.keySet()) {
                                writeMessage("\t" + item + " - " + denominations.get(item));
                            }

                            writeMessage(String.format(res.getString("success.format"), amount, currencyCode));
                            break;
                        } else {
                            writeMessage(res.getString("not.enough.money"));
                        }
                    } catch (NumberFormatException e) {
                        writeMessage(res.getString("specify.not.empty.amount"));
                    }
                }
            } catch (NotEnoughMoneyException e) {
                writeMessage(res.getString("exact.amount.not.available"));
            }
        }
    }
}
