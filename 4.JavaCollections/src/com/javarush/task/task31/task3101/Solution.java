package com.javarush.task.task31.task3101;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Comparator;

/*
Проход по дереву файлов
*/
public class Solution {

    public static void main(String[] args) {
        ArrayList<File> list = new ArrayList<>();
        File path = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);
        File newFile = new File(resultFileAbsolutePath.getParent() + "/allFilesContent.txt");
        if (FileUtils.isExist(resultFileAbsolutePath)) {
            FileUtils.renameFile(resultFileAbsolutePath, newFile);
        }

        try (FileOutputStream fileWriter = new FileOutputStream(newFile)) {
            Files.walkFileTree(path.toPath(), new FileVisitor<Path>() {
                @Override
                public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes basicFileAttributes) {
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) {
                    if (Files.isRegularFile(path)) {
                        if (basicFileAttributes.size() <= 50) {
                            list.add(new File(path.toString()));
                        } else FileUtils.deleteFile(new File(path.toString()));
                    }
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path path, IOException e) {
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path path, IOException e) {
                    return FileVisitResult.CONTINUE;
                }
            });

            list.sort(Comparator.comparing(File::getName));


            for (File paths : list) {
                FileInputStream fileReader = new FileInputStream(paths);
                while (fileReader.available() > 0)
                    fileWriter.write(fileReader.read());
                fileWriter.write(System.lineSeparator().getBytes());
                fileReader.close();
            }
        } catch (IOException ignored) {
        }
    }

}
