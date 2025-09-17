package basic;

import java.util.List;

public class LazyMain01 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9,10);
        List<Integer> result =
                numbers.stream()
                .filter(n-> {
                    boolean isEven = n % 2 == 0;
                    System.out.println("filter() 실행 : " + n + "(" + isEven + ")");
                    return isEven;
                })
                .map(n-> {
                    int mapperNum = n * 10;
                    System.out.println("map() 실행 : " + n + "->" + mapperNum);
                    return mapperNum;
                })
                .toList();      // 최종 연산
        // 최종 연산을 해야지만 중간연산을 실행하고, 없으면 실행하지 않는다.
        System.out.println("result === " + result);
        // 이러한 과정을 Lazy 연산 (Lazy Operator)
        // 반대 연산은 Eager operation JPA(ORM)

        // 스트림을 하는 이유는 데이터 베이스를 다룰 때 List를 많이 사용한다.
        // 가장 좋은 경우는 DB에서 잘 필터링해서 들고 오면 좋다.
    }
}
