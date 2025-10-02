package Quiz;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BlogQuiz03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("나라 이름과 인구를 입력하세요. (예 : Korea 5000)");

        Map<String, Integer> map = new HashMap<>();

        while (true) {
            System.out.print("나라 이름, 인구 >>");
            String country = scanner.next();
            if (country.equals("그만")) {
                break;
            }
            int people = scanner.nextInt();
            map.put(country, people);
        }

        while (true) {
            System.out.print("인구 검색>>");
            String country = scanner.next();

            if (country.equals("그만")) {
                break;
            }

            if (map.get(country) == null) {
                System.out.println(country + " 나라는 없습니다.");
            } else {
                System.out.println(country + "의 인구는 " + map.get(country));
            }
        }
    }
}
