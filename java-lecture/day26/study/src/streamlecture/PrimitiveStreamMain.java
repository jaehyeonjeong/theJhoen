package streamlecture;

import java.util.IntSummaryStatistics;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class PrimitiveStreamMain {
    public static void main(String[] args) {
        // 숫자 Int, Double, Long 기본 스트림보다 좀 더 특화된 느낌...
        IntStream intStream = IntStream.of(1,2,3,4,5);
        intStream.forEach(n-> System.out.print(n + " "));
        System.out.println();

        //특징
        IntStream rangeStream01 = IntStream.range(1,6);   // 1,2,3,4,5
        IntStream rangeStream02 = IntStream.rangeClosed(1,6);   // 1,2,3,4,5,6
        System.out.println(rangeStream01.sum());
//        System.out.println(rangeStream01.max());        // stream은 중복 사용 불가
        System.out.println(rangeStream02.max().orElse(0));
        // Optional로 반환하기 때문에 get메서드 이용해서 Double로 반환
        System.out.println(IntStream.range(1,7).average().orElse(0));
        System.out.println(IntStream.rangeClosed(1,7).max().orElse(0));

        // IntStream 분석기
        IntSummaryStatistics statistics = IntStream.range(1, 6).summaryStatistics();
        System.out.println("statistics.getMax() = " + statistics.getMax());
        System.out.println("statistics.getMin() = " + statistics.getMin());
        System.out.println("statistics.getSum() = " + statistics.getSum());
        System.out.println("statistics.getCount() = " + statistics.getCount());
        System.out.println("statistics.getAverage() = " + statistics.getAverage());
        // 자바가 제공하는 API는 모두 외울 수 없다.
        // 그러니 수시로 연습하고 터득하면서 필요한 부분은 찾으면서 써야하고, 항상 효율성을 생각해야한다.

        // Int 타입만이 아닌 long, Double 타입도 있음
        LongStream longStream = IntStream.rangeClosed(1,6).mapToLong(n->n*10L);
        DoubleStream doubleStream = IntStream.range(1,6).mapToDouble(n->n*1.5);
        System.out.println(longStream.average().orElse(0));
        System.out.println(doubleStream.average().orElse(0));   // 정수에 특화된 Stream, 일반 스트림보다 제공하는게 많음

        // 반복문이 제일 빠르긴함(for가 특히)
        // 일반 Stream은 속도 자체가 느린 편이고, 정수 계산에 관련된건 Int, Long, Double Stream 등
    }
}
