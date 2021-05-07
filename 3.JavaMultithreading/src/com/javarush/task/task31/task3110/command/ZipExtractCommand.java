package com.javarush.task.task31.task3110.command;

import com.javarush.task.task31.task3110.ConsoleHelper;
import com.javarush.task.task31.task3110.ZipFileManager;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipExtractCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        ConsoleHelper.writeMessage("Распаковка архива.");

        ZipFileManager zipFileManager = getZipFileManager();

        ConsoleHelper.writeMessage("Введите путь для распаковки:");
        Path destinationPath = Paths.get(ConsoleHelper.readString());
        zipFileManager.extractAll(destinationPath);

        ConsoleHelper.writeMessage("Архив был распакован.");
    }
}
