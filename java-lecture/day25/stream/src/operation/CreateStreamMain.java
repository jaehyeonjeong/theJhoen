package operation;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.UnaryOperator;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CreateStreamMain {
    public static void main(String[] args) {
        System.out.println("1. Collection에서 생성");
        List<String> list = List.of("a","b","c","d");
        Stream<String> stream01 = list.stream();
        stream01.forEach(System.out::println);


        System.out.println("2. Array에서 생성");
        String[] arr = {"a", "b", "c"};
        Stream<String> stream02 = Arrays.stream(arr);
        stream02.forEach(System.out::println);

        System.out.println("3. Stream으로 직접 생성");
        Stream<String> stream03 = Stream.of("a", "b", "c");
        stream03.forEach(System.out::println);

        // 무한 스트림...???? 이게 뭘까나
        Stream<Integer> infinityStream = Stream.iterate(0, integer->integer + 2).limit(10);
        infinityStream.limit(5).forEach(System.out::println);

        Stream<Double> infinityStream02 = Stream.generate(Math::random);
        infinityStream02.limit(5).forEach(System.out::println);

        Stream<Integer> infinityStream03 = Stream.generate(()->(int)(Math.random()*100)+1);
        infinityStream03.limit(5).forEach(System.out::println);

        // 기본 타입 스트림
        IntStream.range(1, 5).forEach(System.out::println);
        IntStream.rangeClosed(1, 5).forEach(System.out::println);
        DoubleStream.generate(()->(int)(Math.random()*100)).limit(5).forEach(System.out::println);

        // 여기서 사용하는 메서드 limit은 generate, iterate 등 무한으로 출력하는 수들을 limit하는 역할을한다.
    }
}
