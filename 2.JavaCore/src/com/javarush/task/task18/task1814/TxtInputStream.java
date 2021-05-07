package com.javarush.task.task18.task1814;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* 
UnsupportedFileName
*/

public class TxtInputStream extends FileInputStream {
    public TxtInputStream(String fileName) throws IOException, UnsupportedFileNameException {
        super(new File(fileName));
        if (!fileName.matches("^.+\\.txt$")) {
            super.close();
            throw new UnsupportedFileNameException();
        }
    }


    public static void main(String[] args) {
    }
}

