package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

public class ConsoleHelper {

    private static final ResourceBundle RES = ResourceBundle.getBundle(CashMachine.class.getPackage().getName() + ".resources.common");
    private static final BufferedReader BIS = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException {
        String text = null;
        try {
            text = BIS.readLine();
            if ("exit".equals(text.toLowerCase())) {
                throw new InterruptOperationException();
            }
        } catch (IOException ignored) { //suppose it will never occur
        }
        return text;
    }

    public static String askCurrencyCode() throws InterruptOperationException {
        while (true) {
            writeMessage(RES.getString("choose.currency.code"));
            String currencyCode = readString();
            if (currencyCode == null || currencyCode.trim().length() != 3) {
                writeMessage(RES.getString("invalid.data"));
                continue;
            }
            return currencyCode.trim().toUpperCase();
        }
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
        while (true) {
            writeMessage(String.format(RES.getString("choose.denomination.and.count.format"), currencyCode));
            String s = readString();
            String[] split;
            if (s == null || (split = s.split(" ")).length != 2) {
                writeMessage(RES.getString("invalid.data"));
            } else {
                try {
                    if (Integer.parseInt(split[0]) <= 0 || Integer.parseInt(split[1]) <= 0)
                        writeMessage(RES.getString("invalid.data"));
                } catch (NumberFormatException e) {
                    writeMessage(RES.getString("invalid.data"));
                    continue;
                }
                return split;
            }
        }
    }

    public static Operation askOperation() throws InterruptOperationException {
        while (true) {
            writeMessage(RES.getString("choose.operation"));
            writeMessage("\t 1 - " + RES.getString("operation.INFO"));
            writeMessage("\t 2 - " + RES.getString("operation.DEPOSIT"));
            writeMessage("\t 3 - " + RES.getString("operation.WITHDRAW"));
            writeMessage("\t 4 - " + RES.getString("operation.EXIT"));
            Integer i = Integer.parseInt(readString().trim());
            try {
                return Operation.getAllowableOperationByOrdinal(i);
            } catch (IllegalArgumentException e) {
                writeMessage(RES.getString("invalid.data"));
            }
        }
    }

    public static void printExitMessage() {
        writeMessage(RES.getString("the.end"));
    }

}
