package newFiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileName {
    public static void main(String[] args) {
        Path file = Path.of("temp/example.txt");
        Path directory = Path.of("temp/exampleDir");
        Path fakeDirectory = Path.of("temp/exampsdssasda");

        System.out.println("Files.exists(file) === " + Files.exists(file));
        System.out.println("Files.exists(directory) === " + Files.exists(directory));
        System.out.println("Files.exists(fakeDirectory) === " + Files.exists(fakeDirectory));

        try {
            Files.createFile(file);
            System.out.println("file created!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
