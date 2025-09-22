package streamreview;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMain {
    public static void main(String[] args) {
        Stream<String> stringStream = Stream.of("AAA", "BBB", "CCC", "DDD");

//        List<String> stringList =
//                stringStream.map(String::toLowerCase)
//                        .sorted(Comparator.reverseOrder())
//                        .toList();
//        System.out.println(stringList);

        int totalLength =
                stringStream.collect(Collectors.summingInt(String::length));
        System.out.println(totalLength);

        List<Integer> scores = Arrays.asList(80, 90, 75, 85, 95);

        // 점수에 대한 통계 정보 계산
        IntSummaryStatistics stats = scores.stream().collect(Collectors.summarizingInt(score -> score));

        //IntSummaryStatistics을 잘만 이용하면 int만 다루는 통계는 이걸로 진행하는게 좋음
        System.out.println("Statistics: " + stats);
        System.out.println("Statistics.getAverage(): " + stats.getAverage());
        System.out.println("Statistics: " + stats.getSum());
        System.out.println("Statistics: " + stats.getMin());
        System.out.println("Statistics: " + stats.getMax());
    }
}
