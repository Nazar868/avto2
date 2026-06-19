package org.example.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileReaderUtil {

    public static String readFile(String fileName) {

        try {
            return Files.readString(
                    Path.of("sql", fileName)
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
