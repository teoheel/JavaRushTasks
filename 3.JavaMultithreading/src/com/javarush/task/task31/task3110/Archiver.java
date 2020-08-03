package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.exception.WrongZipFileException;

import java.io.IOException;

public class Archiver {
    public static void main(String[] args) {
        Operation operation = null;
        do {
            try {
                operation = askOperation();
                CommandExecutor.execute(operation);
            } catch (WrongZipFileException ignored) {
                ConsoleHelper.writeMessage("Вы не выбрали файл архива или выбрали неверный файл.");
            } catch (Exception ignored) {
                ConsoleHelper.writeMessage("Произошла ошибка. Проверьте введенные данные.");
            }
        }
        while (!Operation.EXIT.equals(operation));
    }

    public static Operation askOperation() throws IOException {
        ConsoleHelper.writeMessage("Выберите операцию: " + System.lineSeparator()
                + "\t" + Operation.CREATE.ordinal() + " - упаковать файлы в архив" + System.lineSeparator()
                + "\t" + Operation.ADD.ordinal() + " - добавить файл в архив" + System.lineSeparator()
                + "\t" + Operation.REMOVE.ordinal() + " - удалить файл из архива" + System.lineSeparator()
                + "\t" + Operation.EXTRACT.ordinal() + " - распаковать архив" + System.lineSeparator()
                + "\t" + Operation.CONTENT.ordinal() + " - просмотреть содержимое архива" + System.lineSeparator()
                + "\t" + Operation.EXIT.ordinal() + " - выход");
        return Operation.values()[ConsoleHelper.readInt()];
    }
}