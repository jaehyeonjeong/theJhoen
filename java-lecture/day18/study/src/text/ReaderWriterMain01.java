package text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import static text.TextConst.*;

public class ReaderWriterMain01 {
    public static void main(String[] args) throws IOException {
        //Reader는 읽기
        //Writer는 쓰기
        String writeStr = "ABCDEFG";

        byte[] writeBytes = writeStr.getBytes(StandardCharsets.UTF_8);
        System.out.println("write String : " + writeStr);
        System.out.println("write bytes : " + Arrays.toString(writeBytes)); // ascii number로 나옴
        FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME);
        fileOutputStream.write(writeBytes);
        fileOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream(FILE_NAME);
        byte[] readBytes = fileInputStream.readAllBytes();
        fileInputStream.close();
        String readString = new String(readBytes,StandardCharsets.UTF_8);
        System.out.println("readBytes : " + Arrays.toString(readBytes));
        System.out.println("readString : " + readString);

        // 중요한 정보(영속화할 데이터)는 데이터베이스에 넣는 반면 간단한 데이터(휘발성 데이터)는 txt 에 저장
        // 요즘은 (redis key value 메모리 db) -> 휘발성 데이터
    }
}
