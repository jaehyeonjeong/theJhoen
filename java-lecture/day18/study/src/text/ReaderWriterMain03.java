package text;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static text.TextConst.FILE_NAME;

public class ReaderWriterMain03 {
    public static void main(String[] args) throws IOException {
        //Reader는 읽기
        //Writer는 쓰기
        String writeStr = "ABCDEFGHIJK";

        byte[] writeBytes = writeStr.getBytes(StandardCharsets.UTF_8);
        System.out.println("write String : " + writeStr);

        // 텍스트를 다룰때는 FileWriter / FileReader를 사용한다.
        FileWriter fileWriter = new FileWriter(FILE_NAME, StandardCharsets.UTF_8);
        fileWriter.write(writeStr);
        fileWriter.close();

        FileReader fileReader = new FileReader(FILE_NAME, StandardCharsets.UTF_8);
        StringBuilder stringBuilder = new StringBuilder();
        int ch;
        while ((ch = fileReader.read()) != -1) {
            stringBuilder.append((char) ch);
        }
        fileReader.close();
        System.out.println("read String : " + stringBuilder);
    }
}
