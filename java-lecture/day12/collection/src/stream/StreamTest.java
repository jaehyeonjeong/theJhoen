package stream;

import java.util.stream.IntStream;

public class StreamTest {
    public static void main(String[] args) {
        IntStream stream1 = IntStream.range(1, 10); // 1 ~ 9
        IntStream stream2 = IntStream.rangeClosed(1, 10); // 1 ~ 10

        // ctrl + Alt + o 를 사용하면 회색으로 표시된 사용하지 않는 문장을 지울 수 있음.
        // 또한 스트림 요소를 출력하기 위해서는 아래처럼 코드를 작성
        stream1.forEach(System.out::print);
        System.out.println();
        stream2.forEach(System.out::print);
    }
}
