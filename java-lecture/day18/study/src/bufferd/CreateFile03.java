package bufferd;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import static bufferd.BufferedConst.*;
//import static bufferd.BufferedConst.FILE_NAME;

public class CreateFile03 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream  = new FileOutputStream(FILE_NAME);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream, BUFFER_SIZE);
        long startTime = System.currentTimeMillis();

        // 버퍼를 사용하는 이유 : 입출력을 빠르게 출력할 수 있다.
        for(int i = 0; i < FILE_SIZE; i++) {
            bufferedOutputStream.write(1);
        }

        fileOutputStream.close();
        long endTime = System.currentTimeMillis();

        System.out.println("File Created : " + FILE_NAME);
        System.out.println("File Size : "  + (FILE_SIZE / 1024 / 1024) + "MB");
        System.out.println("elapsed time : " + (endTime - startTime) + "ms");
    }
}
