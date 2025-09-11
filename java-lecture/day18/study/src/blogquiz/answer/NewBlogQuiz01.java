package blogquiz.answer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class NewBlogQuiz01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("이름과 전화번호를 입력하세요. ex) 정재현 010-2464-2739");
        try {
            // 파일을 저장하기 위해서는 쓰고 저장해야하므로 FileWriter를 사용한다.
            FileWriter fileWriter = new FileWriter("temp/phone.txt");
            while(true) {
                System.out.print("입력 : ");
                String phone = scanner.nextLine();
                if(phone.equals("그만")) break;
                fileWriter.write(phone+System.lineSeparator());
                // System.lineSeparator() : \r\n 과 같은 줄바꿈 역할을 함
            }
            scanner.close();
            fileWriter.close();
            System.out.println("전화번호가 저장되었습니다.");
            // 이렇게하면 비효율적. (컴퓨터 전원이 나가는 경우 데이터가 지워질 수 있음)
            // 영속적으로 저장을 하려면 DB를 써야하는데 아직 거기까진 안배웠음.
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
