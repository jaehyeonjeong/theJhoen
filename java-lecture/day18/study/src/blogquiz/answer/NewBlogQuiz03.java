package blogquiz.answer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class NewBlogQuiz03 {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("c:/temp/system.ini");
            System.out.println("전화번호를 출력한다");

            while(true) {
                int c = fileReader.read(); // 한 글자씩 읽기
                if(c == -1) break;
                char ch = (char) c;
                if(Character.isLowerCase(ch)) {
                    ch = Character.toUpperCase(ch);
                }
                System.out.print(ch);  // c 캐스팅을 하지 않으면 정수만 나온다
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("파일이 없습니다.");
        } catch (IOException e) {
            System.out.println("파일을 출력할 수 없습니다.");
        }
    }
}
