package blogquiz;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class BlogQuiz01 {
    //1. Scanner로 입력받은 이름과 전화번호를 한 줄에 한 사람씩 c:\Temp\phone.txt파일에 저장하라.
    //   "그만"을 입력하면 프로그램을 종료한다.
    private static final String FILE_NAME = "c:/Temp/phone.txt";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        FileWriter fileWriter = new FileWriter(FILE_NAME, StandardCharsets.UTF_8);
        while(true) {
            System.out.print("이름, 전화번호 : ");
            String inputName = scanner.nextLine(); // 이름
            if(inputName.equals("그만")) break;
            try {
                fileWriter.write(inputName + "\n");
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
        fileWriter.close();

    }
}
