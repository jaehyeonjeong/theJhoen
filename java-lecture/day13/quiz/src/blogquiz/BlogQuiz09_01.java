package blogquiz;

import java.util.*;

public class BlogQuiz09_01 {
    public static void main(String[] args) {
        Map<String, Nation> nationMap = new HashMap<>();
        nationMap.put("대한민국", new Nation("대한민국", "서울"));
        nationMap.put("그리스", new Nation("그리스", "아테네"));
        nationMap.put("호주", new Nation("호주", "캔버라"));
        nationMap.put("이탈리아", new Nation("이탈리아", "로마"));
        nationMap.put("일본", new Nation("일본", "도쿄"));
        nationMap.put("캐나다", new Nation("캐나다", "오타와"));

//        System.out.println(nationList.get(0)); // 대한민국`
        System.out.println("수도 맞추기 게임을 시작합니다. 나라이름이 나오면 수도이름을 입력하세여.");

        //String[] strArrNation = {"대한민국", "그리스", "호주", "이탈리아", "일본", "캐나다"};
        Set<String> keySet = nationMap.keySet();
        List<String> stringList = new ArrayList<>(keySet);  // ArrayList
        // 배열로 만들 필요 없이 리스트로 바로 값을 넣어도 무방하다.
//        Object[] keyArray = keySet.toArray();       // 배열로 바뀐다 (불변 객체)

        while (true) {
            Scanner scanner = new Scanner(System.in);
            Random random = new Random();
            int nRandom = random.nextInt(nationMap.size());
            System.out.println(stringList.get(nRandom) + "의 수도는?");

            String keyString = stringList.get(nRandom);
            String getCapital = nationMap.get(keyString).getCapital();
            String setCapital = scanner.next();
            if (setCapital.equals("그만")) break;
            if (getCapital.equals(setCapital)) {
                System.out.println("정답!");
            } else {
                System.out.println("땡!");
            }
        }
    }
}
