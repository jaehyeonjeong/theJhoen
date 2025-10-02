package bufferd;

import java.io.FileInputStream;
import java.io.IOException;

import static bufferd.BufferedConst.*;

public class ReadFile01 {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(FILE_NAME);
        long startTime = System.currentTimeMillis();

        int size = 0;
        int fileSize = 0;
        byte[] buffer = new byte[BUFFER_SIZE];
        // 버퍼를 할당하려면 밑에 있는 size 부분에 read 버퍼를 할당해야함.
        while((size=fileInputStream.read(buffer)) != -1) {
            fileSize += size;
        }

        fileInputStream.close();
        long endTime = System.currentTimeMillis();

        System.out.println("File Created : " + FILE_NAME);
        System.out.println("File Size : "  + (fileSize / 1024 / 1024) + "MB");
        System.out.println("elapsed time : " + (endTime - startTime) + "ms");
    }
}
