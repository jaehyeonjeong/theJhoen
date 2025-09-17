package operation;

import java.util.Comparator;
import java.util.List;

public class IntermediateOperationMain {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1,2,2,4,4,5,3,8,6,7,9,10);
        // 1. filter
        System.out.println("1. filter 짝수만 출력"); // filter는 continue 느낌
        numbers.stream().filter(n->n%2 ==0).forEach(n-> System.out.print(n + " "));
        System.out.println("\n=============================================");

        // 2. map
        System.out.println("2. map 제곱 출력");
        numbers.stream().map(n->n*n).forEach(n-> System.out.print(n + " "));
        System.out.println("\n=============================================");

        // 3. distinct
        System.out.println("3. distinct 중복제거");
        numbers.stream().distinct().forEach(n-> System.out.print(n + " "));
        System.out.println("\n=============================================");

        // 4. sorted
        System.out.println("4. sorted 기본 정렬");
        numbers.stream().sorted().forEach(n-> System.out.print(n + " "));
        System.out.println("\n=============================================");

        // 5. sorted 내림차순
        System.out.println("5. sorted 내림차순 정렬");
        numbers.stream().sorted(Comparator.reverseOrder()).forEach(n-> System.out.print(n + " "));
        System.out.println("\n=============================================");

        // 6. peek 동작 확인용
        System.out.println("6. peek 동작 확인용");
        numbers.stream()
                .peek(n-> System.out.print("\nbefore : " + n + ", "))
                .map(n->n*n)
                .peek(n-> System.out.print("after : " + n + ", "))
                .forEach(n-> System.out.print(n + " "));
        System.out.println("\n=============================================");


        // 7. limit 처음 몇 개만 들고오기
        System.out.println("7. limit() 처음 몇 개만 들고오기");
        numbers.stream()
                .distinct()     // 중복 제거
                .limit(5)
                .forEach(n-> System.out.print(n + " "));
        System.out.println("\n=============================================");

        // 8. skip
        System.out.println("8. skip() 처음 몇 개만 건너뛰기");
        numbers.stream()
                .distinct()     // 중복 제거
                .sorted()       // 정렬
                .skip(5)
                .forEach(n-> System.out.print(n + " "));
        System.out.println("\n=============================================");

        // 9. take while
        System.out.println("9. takeWhile() 조건을 만족하는 동안 가져온다.");
        numbers.stream()
                .takeWhile(n->n < 4)        // 지정한 수만 출력 (멈춘다 : filter + break)
                .forEach(n-> System.out.print(n + " "));
        System.out.println("\n=============================================");

        // 10. drop while
        System.out.println("10. dropWhile() 조건을 만족하는 동안 가져온다.");
        numbers.stream()
                .dropWhile(n->n < 4)        // 4보다 작은 동안 건너뛰기 -> 이후에 4보다 작은 수가 나오더라도 무조건 출력
                .forEach(n-> System.out.print(n + " "));
        System.out.println("\n=============================================");
    }
}
