package bufferd;

import java.io.FileOutputStream;
import java.io.IOException;

import static bufferd.BufferedConst.*;
//import static bufferd.BufferedConst.FILE_NAME;

public class CreateFile01 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream  = new FileOutputStream(FILE_NAME);
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < FILE_SIZE; i++) {
            fileOutputStream.write(1);
        }
        fileOutputStream.close();
        long endTime = System.currentTimeMillis();

        System.out.println("File Created : " + FILE_NAME);
        System.out.println("File Size : "  + FILE_SIZE);
        System.out.println("elapsed time : " + (endTime - startTime) + "ms");
    }
}
