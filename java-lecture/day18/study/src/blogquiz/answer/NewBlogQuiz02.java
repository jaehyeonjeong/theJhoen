package blogquiz.answer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class NewBlogQuiz02 {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("temp/phone.txt");
            System.out.println("전화번호를 출력한다");

            while(true) {
                int c = fileReader.read(); // 한 글자씩 읽기
                if(c == -1) break;
                System.out.print((char)c);  // c 캐스팅을 하지 않으면 정수만 나온다
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("파일이 없습니다.");
        } catch (IOException e) {
            System.out.println("파일을 출력할 수 없습니다.");
        }
    }
}
