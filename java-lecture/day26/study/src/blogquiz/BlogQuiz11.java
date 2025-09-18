package blogquiz;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BlogQuiz11 {
    //11. 다음 주어진 두개의 배열을 가지고 영어를 키로 가지고 한글을 값으로 가지는 map을 만드시오
    // 아니 이건 ㅋㅋ 못 했음 지피티로 해서
    public static void main(String[] args) {
        String[] koreanArray = {"사과", "바나나", "체리", "딸기"};
        String[] englishArray = {"apple", "banana", "cherry", "strawberry"};

        // 배열의 인덱스를 기준으로 Stream 생성
        Map<String, String> map = IntStream.range(0, koreanArray.length)
                .boxed()
                .collect(Collectors.toMap(i -> englishArray[i], i -> koreanArray[i]));

        System.out.println(map);
    }
}
