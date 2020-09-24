package com.javarush.task.task26.task2613.command;


import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.ResourceBundle;

import static com.javarush.task.task26.task2613.ConsoleHelper.readString;
import static com.javarush.task.task26.task2613.ConsoleHelper.writeMessage;

class LoginCommand implements Command {
    private final ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "verifiedCards");
    private final ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "login");


    @Override
    public void execute() throws InterruptOperationException {
        writeMessage(res.getString("before"));

        while (true) {
            writeMessage(res.getString("specify.data"));
            String creditCardNumber = readString();
            String pinStr = readString();
            if (creditCardNumber == null || (creditCardNumber = creditCardNumber.trim()).length() != 12 ||
                    pinStr == null || (pinStr = pinStr.trim()).length() != 4) {
                writeMessage(res.getString("try.again.with.details"));
            } else {
                try {
                    if (validCreditCards.containsKey(creditCardNumber) && pinStr.equals(validCreditCards.getString(creditCardNumber))) {
                        writeMessage(String.format(res.getString("success.format"), creditCardNumber));
                        break;
                    } else {
                        writeMessage(String.format(res.getString("not.verified.format"), creditCardNumber));
                        writeMessage(res.getString("try.again.or.exit"));
                    }
                } catch (NumberFormatException e) {
                    writeMessage(res.getString("try.again.with.details"));
                }
            }
        }

    }
}
