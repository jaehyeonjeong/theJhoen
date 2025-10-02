package blogquiz.answer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class NewBlogQuiz01_02 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("이름과 전화번호를 입력하세요. ex) 정재현 010-2464-2739");

        // 파일을 저장하기 위해서는 쓰고 저장해야하므로 FileWriter를 사용한다.
        FileWriter fileWriter = new FileWriter("temp/phone2.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        try {
            while(true) {
                System.out.print("입력 : ");
                String phone = scanner.nextLine();
                if(phone.equals("그만")) break;
                bufferedWriter.write(phone);
                bufferedWriter.newLine();   // BufferedWriter에서 제공하는 \r\n
            }
            System.out.println("전화번호가 저장되었습니다.");

            bufferedWriter.close();     // 이번에는 bufferedWriter write했으니   bufferedWriter.close()를 해야함
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {

            scanner.close();
        }
    }
}
