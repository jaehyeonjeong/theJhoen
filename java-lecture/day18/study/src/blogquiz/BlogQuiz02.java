package blogquiz;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static text.BufferedConst.BUFFER_SIZE;
import static text.TextConst.FILE_NAME;

public class BlogQuiz02 {
    //1. Scanner로 입력받은 이름과 전화번호를 한 줄에 한 사람씩 c:\Temp\phone.txt파일에 저장하라.
    //   "그만"을 입력하면 프로그램을 종료한다.
    private static final String FILE_NAME = "c:/Temp/phone.txt";

    public static void main(String[] args) throws IOException {
//        Scanner scanner = new Scanner(System.in);
        FileReader fileReader = new FileReader(FILE_NAME, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(fileReader, BUFFER_SIZE);
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line).append("\n");    // append를 연속으로 넣을 수 있음.
        }

        System.out.println(stringBuilder);
    }
}
