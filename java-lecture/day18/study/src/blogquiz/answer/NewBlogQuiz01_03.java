package blogquiz.answer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class NewBlogQuiz01_03 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("temp/phone3.txt"));
        // try with resource : try가 끝나면 자동으로 닫음 BufferedWriter 클래스 안에 closable이 impelement되어 있기 때문
        // 해당 방식은 java 9버전 이상에서만 지원이 가능
        try (bufferedWriter) {
            System.out.println("이름과 전화번호를 입력하세요. ex) 정재현 010-2464-2739");

            while (true) {
                System.out.print("입력 : ");
                String phone = scanner.nextLine();
                if (phone.equals("그만")) break;
                bufferedWriter.write(phone);
                bufferedWriter.newLine();   // BufferedWriter에서 제공하는 \r\n
            }
            System.out.println("전화번호가 저장되었습니다.");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
