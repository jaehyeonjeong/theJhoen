package blogquiz;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BlogQuiz03 {
    public static void main(String[] args) {
        Map<String, Integer> country = new HashMap<>();

        country.put("한국", 50_000_000);
        country.put("미국", 500_000_000);
        country.put("중국", 1_000_000_000);
        country.put("일본", 100_000_000);
        country.put("스위스", 20_000_000);
        country.put("영국", 55_000_000);
//        System.out.println(country.get("한국"));

        Scanner scanner = new Scanner(System.in);
        while(true) {
            String str = scanner.next();
            if(str.equals("그만")) break;
            int nPopulation = country.get(str);
            System.out.println(str+ "의 인구수 : " + nPopulation);
        }
    }
}
