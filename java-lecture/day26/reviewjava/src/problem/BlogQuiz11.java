package problem;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class BlogQuiz11 {

    // 11. 다음 주어진 두개의 배열을 가지고 영어를 키로 가지고 한글을 값으로 가지는 map을 만드시오

    public static void main(String[] args) {
         String[] koreanArray = {"사과", "바나나", "체리", "딸기"};
         String[] englishArray = {"apple", "banana", "cherry", "strawberry"};

        final int[] n = {0};
        try {
            //   key        value
            Map<String, List<String>> map =
                    // 영어를 키 값으로 가져가야 하기 떄문에 한글 데이터를 순차적으로 써야한다.
                    Arrays.stream(koreanArray)
                            .collect(Collectors.groupingBy((Function<Object, String>) name -> englishArray[n[0]++]));
            System.out.println(map);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }

    }
}
