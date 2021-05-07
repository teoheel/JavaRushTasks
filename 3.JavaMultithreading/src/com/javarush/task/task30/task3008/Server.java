package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(ConsoleHelper.readInt())) {
            ConsoleHelper.writeMessage("Сервер запущен");
            while (true) {
                new Handler(server.accept()).start();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void sendBroadcastMessage(Message message) {
        for (Connection connection : connectionMap.values()) {
            try {
                connection.send(message);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            Message message;
            String userName;
            do {
                connection.send(new Message(MessageType.NAME_REQUEST));
                message = connection.receive();
                userName = message.getData();
            } while (!message.getType().equals(MessageType.USER_NAME) || (userName == null || userName.isEmpty()) || connectionMap.containsKey(userName));
            connectionMap.put(userName, connection);
            connection.send(new Message(MessageType.NAME_ACCEPTED));
            return userName;
        }

        private void notifyUsers(Connection connection, String userName) throws IOException {
            for (String name : connectionMap.keySet()) {
                if (!name.equals(userName)) {
                    connection.send(new Message(MessageType.USER_ADDED, name));
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                if (message.getType() == (MessageType.TEXT)) {
                    String text = String.format("%s: %s", userName, message.getData());
                    sendBroadcastMessage(new Message(MessageType.TEXT, text));
                } else ConsoleHelper.writeMessage("Произошла ошибка");
            }
        }

        public void run() {
            ConsoleHelper.writeMessage("Установлено соединение с " + socket.getRemoteSocketAddress());
            String userName = null;
            try (Connection connection = new Connection(socket)) {
                userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                notifyUsers(connection, userName);
                serverMainLoop(connection, userName);
            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage("Произошла ошибка соединения");
            } finally {
                if (userName != null) {
                    connectionMap.remove(userName);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
                }
            }
        }
    }
}
