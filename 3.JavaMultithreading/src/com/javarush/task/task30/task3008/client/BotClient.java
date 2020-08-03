package com.javarush.task.task30.task3008.client;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BotClient extends Client {
    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        return String.format("%s%d", "date_bot_", (int) (Math.random() * 100));
    }

    public class BotSocketThread extends SocketThread {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            super.processIncomingMessage(message);
            String name, command;
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat dateFormat;
            if (message.contains(": ")) {
                name = message.substring(0, message.indexOf(':'));
                command = message.substring(message.indexOf(':') + 2);
                if (command.equalsIgnoreCase("дата")) {
                    dateFormat = new SimpleDateFormat("d.MM.YYYY");
                } else if (command.equalsIgnoreCase("день")) {
                    dateFormat = new SimpleDateFormat("d");
                } else if (command.equalsIgnoreCase("месяц")) {
                    dateFormat = new SimpleDateFormat("MMMM");
                } else if (command.equalsIgnoreCase("год")) {
                    dateFormat = new SimpleDateFormat("YYYY");
                } else if (command.equalsIgnoreCase("время")) {
                    dateFormat = new SimpleDateFormat("H:mm:ss");
                } else if (command.equalsIgnoreCase("час")) {
                    dateFormat = new SimpleDateFormat("H");
                } else if (command.equalsIgnoreCase("минуты")) {
                    dateFormat = new SimpleDateFormat("m");
                } else if (command.equalsIgnoreCase("секунды")) {
                    dateFormat = new SimpleDateFormat("s");
                } else return;
                Date date = calendar.getTime();
                sendTextMessage("Информация для " + name + ": " + dateFormat.format(date));
            }
        }
    }
}
