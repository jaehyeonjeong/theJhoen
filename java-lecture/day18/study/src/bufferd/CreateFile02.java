package bufferd;

import java.io.FileOutputStream;
import java.io.IOException;

import static bufferd.BufferedConst.*;
//import static bufferd.BufferedConst.FILE_NAME;

public class CreateFile02 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream  = new FileOutputStream(FILE_NAME);
        long startTime = System.currentTimeMillis();

        byte[] buffer = new byte[BUFFER_SIZE];
        int bufferedIndex = 0;
        // 버퍼를 사용하는 이유 : 입출력을 빠르게 출력할 수 있다.
        for(int i = 0; i < FILE_SIZE; i++) {
            //fileOutputStream.write(1);
            buffer[bufferedIndex] = 1;
            bufferedIndex++;
            if(bufferedIndex == BUFFER_SIZE) {
                fileOutputStream.write(buffer);
                bufferedIndex = 0;
            }
        }
        // 남아있는 것을 강제로 밀어넣기
        if(bufferedIndex > 0) {
            fileOutputStream.write(buffer, 0, bufferedIndex);
        }
        fileOutputStream.close();
        long endTime = System.currentTimeMillis();

        System.out.println("File Created : " + FILE_NAME);
        System.out.println("File Size : "  + (FILE_SIZE / 1024 / 1024) + "MB");
        System.out.println("elapsed time : " + (endTime - startTime) + "ms");
    }
}
