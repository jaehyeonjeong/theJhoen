package lambda.filter;

import java.util.List;

public class FilterMain02 {
    public static void main(String[] args) {

        List <String> stringList = List.of("A", "AAA", "ABC", "ABCD");
        // String 값을 하나씩 호출했을 때 길이가 2이상인지 확인
        List <String> resultString = GenericFilter.filter(stringList,
                s-> s.length() >= 2);
        // 걸러진 리스트 값들만 출력
        System.out.println(resultString);
    }
}
