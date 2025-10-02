package blogquiz.answer;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NewBlogQuiz06 {
    private static final int BUFFER_SIZE = 1024 * 8;

    public static void main(String[] args) {
        Map<String, String> phoneMap = new HashMap<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("temp/phone.txt"), BUFFER_SIZE)) {

//            Scanner scanner = new Scanner(bufferedReader);

//            while(scanner.hasNext()) {
//                String key = scanner.next(); // 한칸 띄워져 있어서 next만 붙여도 됨.
//                String value = scanner.next();
//
//                phoneMap.put(key, value);
//            }
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                line = line.trim();                         //  추출된 라인의 양 옆공백을 지우기
                String[] parts = line.split("\\s+");  //  정규식 \\s+로 공백 인식
                if (line.isEmpty()) continue;               // 만약 line 문자열이 공백이면 건너 띄우기 (put안함)
                String key = parts[0];
                String value = parts[1];
                phoneMap.put(key, value);
            }
//            scanner.close();
            System.out.println(phoneMap.size() + "개의 전화번호가 있습니다. 이름을 입력하면 전화번호를 알려드리겠습니다.");
            Scanner inputScanner = new Scanner(System.in);
            while (true) {
                System.out.print("이름 : ");
                String name = inputScanner.next();
                if (name.equals("그만")) break;
                String tel = phoneMap.get(name);
                if (tel == null) System.out.println("없는 사람입니다.");
                else System.out.println(tel);
            }
            System.out.println("프로그램을 종료합니다.");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
