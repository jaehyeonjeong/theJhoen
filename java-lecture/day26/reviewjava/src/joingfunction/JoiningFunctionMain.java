package joingfunction;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JoiningFunctionMain {
    public static void main(String[] args) {
        // 매개변수 1개
        Stream<String> stream = Stream.of("1","2","3","4","5");
        // 이거 되게 유용하게 사용할 것 같은데?
        String joining = stream.collect(Collectors.joining(","));
        System.out.println(joining);

        // 매개 변수가 3개
        Stream<String> stream02 = Stream.of("1","2","3","4","5");
        // joing의 파라미터(중산 삽입 문자, 맨 앞 문자, 맨 뒤 문자)
        String joining02 = stream02.collect(Collectors.joining(",", "문자열 시작 [", "} 문자열 끝"));
        System.out.println(joining02);
    }
}
