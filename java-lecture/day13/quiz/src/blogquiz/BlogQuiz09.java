package blogquiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BlogQuiz09 {
    public static void main(String[] args) {
        List<Nation> nationList = new ArrayList<>();

        nationList.add(new Nation("대한민국", "서울"));
        nationList.add(new Nation("그리스", "아테네"));
        nationList.add(new Nation("호주", "캔버라"));
        nationList.add(new Nation("이탈리아", "로마"));
        nationList.add(new Nation("일본", "도쿄"));
        nationList.add(new Nation("캐나다", "오타와"));

//        System.out.println(nationList.get(0)); // 대한민국`
        System.out.println("수도 맞추기 게임을 시작합니다. 나라이름이 나오면 수도이름을 입력하세여.");
        Scanner scanner = new Scanner(System.in);

        while(true) {

            Random random = new Random();
            int nRandom = random.nextInt(nationList.size());
            System.out.println(nationList.get(nRandom).getCountry() + "의 수도는?");
            String getCapital = nationList.get(nRandom).getCapital();
            String setCapital = scanner.next();
            if(setCapital.equals("그만")) break;
            if(getCapital.equals(setCapital)) {
                System.out.println("정답!");
            }
            else {
                System.out.println("땡!");
            }

        }
    }

}
