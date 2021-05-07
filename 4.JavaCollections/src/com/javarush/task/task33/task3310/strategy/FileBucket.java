package com.javarush.task.task33.task3310.strategy;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.javarush.task.task33.task3310.ExceptionHandler.log;

public class FileBucket {
    Path path;

    public FileBucket() {
        try {
            path = Files.createTempFile(null, null);
            Files.deleteIfExists(path);
            Files.createFile(path);
            path.toFile().deleteOnExit();
        } catch (IOException e) {
            log(e);
        }
    }

    public long getFileSize() {
        long fileSize = 0L;
        try {
            fileSize = Files.size(path);
        } catch (IOException e) {
            log(e);
        }
        return fileSize;
    }

    public void putEntry(Entry entry) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(Files.newOutputStream(path))) {
            outputStream.writeObject(entry);
        } catch (IOException e) {
            log(e);
        }
    }

    public Entry getEntry() {
        Entry entry = null;
        if (getFileSize() == 0) {
            return null;
        }
        try (ObjectInputStream inputStream = new ObjectInputStream(Files.newInputStream(path))) {
            entry = (Entry) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            log(e);
        }
        return entry;
    }

    public void remove() {
        try {
            Files.delete(path);
        } catch (IOException e) {
            log(e);
        }
    }
}
