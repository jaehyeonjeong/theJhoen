package text;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static text.TextConst.FILE_NAME;

public class ReaderWriterMain02 {
    public static void main(String[] args) throws IOException {
        //Reader는 읽기
        //Writer는 쓰기
        String writeStr = "ABCDEFG";

        byte[] writeBytes = writeStr.getBytes(StandardCharsets.UTF_8);
        System.out.println("write String : " + writeStr);
        System.out.println("write bytes : " + Arrays.toString(writeBytes)); // ascii number로 나옴

        FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8);
        outputStreamWriter.write(writeStr);
        outputStreamWriter.close();

        FileInputStream fileInputStream = new FileInputStream(FILE_NAME);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
        int ch = 0;
        StringBuilder stringBuilder = new StringBuilder();
        // varchar
        while((ch=inputStreamReader.read()) != -1){
            stringBuilder.append((char)ch);
        }
        inputStreamReader.close();

        System.out.println("readString : " + stringBuilder);

        // 중요한 정보(영속화할 데이터)는 데이터베이스에 넣는 반면 간단한 데이터(휘발성 데이터)는 txt 에 저장
        // 요즘은 (redis key value 메모리 db) -> 휘발성 데이터
    }
}
