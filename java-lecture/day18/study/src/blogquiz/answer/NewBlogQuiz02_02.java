package blogquiz.answer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class NewBlogQuiz02_02 {
    private static final int BUFFER_SIZE = 1024 * 8;
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("temp/phone.txt");
            // Buffer를 받으면서 파일에 있는 문자를 읽기 위함, 고속으로 처리하기 위함.
            BufferedReader bufferedReader = new BufferedReader(fileReader, BUFFER_SIZE);
            System.out.println("전화번호를 출력한다");

            // 한문장을 읽게 하기 위함
            while (true) {
                String line = bufferedReader.readLine();
                if(line == null) break;
                System.out.println(line);
            }

            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("파일이 없습니다.");
        } catch (IOException e) {
            System.out.println("파일을 출력할 수 없습니다.");
        }
    }
}
