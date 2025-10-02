package text;

import java.io.*;
import java.nio.charset.StandardCharsets;
import static text.BufferedConst.*;

import static text.TextConst.FILE_NAME;

public class ReaderWriterMain04 {
//    private static final int BUFFER_SIZE = 8 * 1024;

    public static void main(String[] args) throws IOException {
        //Reader는 읽기
        //Writer는 쓰기

        String writeStr = "ABCDEFGHIJK\n가나다";

        byte[] writeBytes = writeStr.getBytes(StandardCharsets.UTF_8);
        System.out.println("write String : " + writeStr);

        // 텍스트를 다룰때는 FileWriter / FileReader를 사용한다.
        FileWriter fileWriter = new FileWriter(FILE_NAME, StandardCharsets.UTF_8);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter, BUFFER_SIZE);
        bufferedWriter.write(writeStr);
        bufferedWriter.close();

        FileReader fileReader = new FileReader(FILE_NAME, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(fileReader, BUFFER_SIZE);
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line).append("\n");    // append를 연속으로 넣을 수 있음.
        }
        bufferedReader.close();
        System.out.println("read String : " + stringBuilder);
    }
}
