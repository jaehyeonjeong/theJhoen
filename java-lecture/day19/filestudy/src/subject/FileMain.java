package subject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileMain {
    public static void main(String[] args) throws IOException {
        String destFilePath = "./temp/newDir/another/dir.txt";

        File file = new File(destFilePath);

        Path path = file.toPath();

        System.out.println( Files.isDirectory(path));
    }
}
