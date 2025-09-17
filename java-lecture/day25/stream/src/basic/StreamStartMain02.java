package basic;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamStartMain02 {
    public static void main(String[] args) {
        // stream : 뜻 풀이 -> 실개천??
        // Collection들 List, Map 등이 stream으로 연결

        List<String> names = List.of("Apple", "Banana", "Blueberry", "Tomato");

        // 대문자 B로 시작하는 애들을 뽑아서 전부 대문자로 바꾸기
        Stream<String> stream = names.stream();
        // 매서드 채이닝이 가능
        List<String> result = stream.filter(new Predicate<String>() {
                    @Override
                    public boolean test(String string) {
                        return string.startsWith("B");
                    }
                })
                .map(new Function<String, String>() {
                    @Override
                    public String apply(String string) {
                        return string.toUpperCase();
                    }
                })
                .toList();      // 리스트 형태로 출력
        System.out.println(result);

        for(String str : result) {
            System.out.print(str + ",");
        }
        System.out.println();

        // names 재호출
        names.stream()
                .filter(name->name.startsWith("B"))         // 중간 연산 1 : 데이터를 걸러내거나
                .map(String::toUpperCase)                         // 중간 연산 2 : 형태를 바꾸거나
                .forEach(System.out::println);                    // 최종 연산
        // :: 매서드를 입력하면 들여쓰기가 안됨(println).
        // :: 은 람다의 축약형이고 제한은 되지만 코드의 낭비를 줄일 수 있는 방법 중 하나
        // 너무 남발하면 안됨.

        // stream의 특징(중요)
        // 1. 원본을 훼손하지 않는다.(imutable : 불변) 데이터 변경이 일어나지 않는다.
        // 2. 1회용이다. 한번 사용하면 재활용이 불가능하다. 필요하면 다시 생성해서 짜야한다.
        // 3. pipe line 구성을 할 수 있다. 중간연산 -> 최종연산
        // 4. 지연 연산 (lazy operation) 중간연산이 필요할 떄까지 실제로 동작하지 않는다. 최종연산이 실행될 때 한번에 처리된다.
        // 5. 병렬 처리에 용이하다.  parallel stream을 만들 수 있다.



        // 스트림은 한번 쓰고나면 재활용이 안됨
        // 매서드 채이닝이 가능
//        List<String> result02 = stream.filter(new Predicate<String>() {
//                    @Override
//                    public boolean test(String string) {
//                        return string.startsWith("B");
//                    }
//                })
//                .map(new Function<String, String>() {
//                    @Override
//                    public String apply(String string) {
//                        return string.toUpperCase();
//                    }
//                })
//                .toList();
//        System.out.println(result02);
    }
}
