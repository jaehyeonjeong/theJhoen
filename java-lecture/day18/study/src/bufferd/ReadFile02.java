package bufferd;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import static bufferd.BufferedConst.BUFFER_SIZE;
import static bufferd.BufferedConst.FILE_NAME;

public class ReadFile02 {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(FILE_NAME);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream, BUFFER_SIZE);
        long startTime = System.currentTimeMillis();

        int fileSize = 0;
        // 버퍼를 할당하려면 밑에 있는 size 부분에 read 버퍼를 할당해야함.
        while((bufferedInputStream.read()) != -1) {
            fileSize++;
        }

        fileInputStream.close();
        long endTime = System.currentTimeMillis();

        System.out.println("File Created : " + FILE_NAME);
        System.out.println("File Size : "  + (fileSize / 1024 / 1024) + "MB");
        System.out.println("elapsed time : " + (endTime - startTime) + "ms");
    }
}
