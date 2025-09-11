package blogquiz;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static text.BufferedConst.BUFFER_SIZE;

public class BlogQuiz03 {
    private static final String FILE_NAME = "c:/windows/system.ini";
    private static final String COPY_FILE_NAME = "c:/Temp/system.ini";
    private static final int BUFFER_SIZE = 8 * 1024;

    //3. c:\windows\system.ini 파일을 읽어 소문자 모두를 대문자로 바꾸어 출력하라.
    //반드시 ini파일을 복사해서 temp파일에 붙여넣고 써라
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(FILE_NAME, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(fileReader, BUFFER_SIZE);
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilderCopy = new StringBuilder();

        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line).append("\n");    // append를 연속으로 넣을 수 있음.

            stringBuilderCopy.append(line.toUpperCase()).append("\n"); // 복사할 문장을 다른 변수에 저장
        }
        fileReader.close();

        System.out.println(stringBuilder);

        // 복사할 파일의 위치를 정확히 변경하고 만들어야 한다.
        FileWriter fileWriter = new FileWriter(COPY_FILE_NAME, StandardCharsets.UTF_8);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter, BUFFER_SIZE);
        bufferedWriter.write(stringBuilderCopy.toString());
        bufferedWriter.close();
    }
}
