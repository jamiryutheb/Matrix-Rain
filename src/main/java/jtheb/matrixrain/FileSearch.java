package jtheb.matrixrain;

import java.io.File;
import java.nio.file.Path;

public class FileSearch {

    public File searchDirectory(Path directory, String fileName) {
        File[] files = directory.toFile().listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    File result = searchDirectory(file.toPath(), fileName);
                    if (result != null) {
                        return result;
                    }
                } else {
                    if (file.getName().equals(fileName)) {
                        return file;
                    }
                }
            }
        }
        return null;
    }

}
