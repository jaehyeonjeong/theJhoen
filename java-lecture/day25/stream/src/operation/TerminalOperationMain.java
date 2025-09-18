package operation;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
// 최종연산
public class TerminalOperationMain {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 2, 3, 4, 4, 5, 3, 8, 6, 7, 9, 10);

        System.out.println("1. collect List 수집");
        List<Integer> evenNumbers01 = numbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        System.out.println("짝수 리스트 : " + evenNumbers01);
        evenNumbers01.add(100); // 가변객체 mutable
        System.out.println("========================================");


        // java 16버전
        System.out.println("2. toList 수집");
        List<Integer> evenNumbers02 = numbers.stream().filter(n -> n % 2 == 0).toList();
        System.out.println("짝수 리스트 : " + evenNumbers02);
//        evenNumbers02.add(100); // 불변객체 immutable
        System.out.println("========================================");

        System.out.println("3. toArray 배열로 반환");
        Integer[] evenNumbers03 = numbers.stream().filter(n -> n % 2 == 0).toArray(Integer[]::new);
        System.out.println("짝수 배열 : " + Arrays.toString(evenNumbers03));
        System.out.println("========================================");


        System.out.println("4. foreach 각 요소 처리");
        numbers.stream().filter(n -> n % 2 == 0).forEach(n-> System.out.print(n + " "));
        System.out.println("\n========================================");


        System.out.println("5. count - 개수 처리");
        long count = numbers.stream().filter(n -> n > 5).count();
        System.out.println("5보다 큰 숫자의 개수 : " + count);
        System.out.println("\n========================================");

        System.out.println("6-1. reduce 요소들의 합");
        Optional<Integer> optional = numbers.stream()
                .reduce((a, b) -> a + b);       // NullPointEx
        System.out.println("각 요소들의 합 초기값 없음 : " + optional.get());  // Optional은 null 체크용
//        System.out.println("각 요소들의 합 초기값 없음 : " + optional.orElse(0));  // Optional은 null 체크용
        System.out.println("\n========================================");

        System.out.println("6-2. reduce 요소들의 합");
        int optional02 = numbers.stream()
                .reduce(0, new BinaryOperator<Integer>() {
                    @Override
                    public Integer apply(Integer a, Integer b) {
                        return a + b;
                    }
                });       // 초기값을 부여
        System.out.println("각 요소들의 합 초기값 있음 : " + optional02);  // 초기값 부터 + 연산 진행
        System.out.println("\n========================================");


        System.out.println("6-3. reduce 요소들의 합");

        List<Integer> empty = List.of();
        Optional<Integer> optional03 = empty.stream()
                .reduce((a, b) -> a + b);       // NullPointEx
//        System.out.println("각 요소들의 합 초기값 없음 : " + optional03.get());  // 배열이 null이면 에러 터짐
        System.out.println("각 요소들의 합 초기값 없음 : " + optional03.orElse(0));
        if(optional03.isPresent()) {
            System.out.println("if로 들어간 값 : " + optional03.get());
        } else {
            System.out.println("else 문.. 값이 없다잉");
        }
        System.out.println("\n========================================");


        System.out.println("7. min 최소값");
        Optional<Integer> op1 = numbers.stream().min(Integer::compareTo);
        System.out.println("제일 작은 숫자 : " + op1.get());
        System.out.println("\n========================================");

        System.out.println("7-1. min 최소값");
        Optional<Integer> op11 = numbers.stream().min(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println("제일 작은 숫자 : " + op11.get());
        System.out.println("\n========================================");

        System.out.println("7-2. min 최소값");
        Optional<Integer> op12 = numbers.stream().min((o1, o2) -> o1.compareTo(o2));
        System.out.println("제일 작은 숫자 : " + op12.get());
        System.out.println("\n========================================");


        System.out.println("8. max 최대값");
        Optional<Integer> op2 = numbers.stream().max(Integer::compareTo);
        System.out.println("제일 큰 숫자 : " + op2.get());
        System.out.println("\n========================================");

        System.out.println("8-1. max 최대값");
        Optional<Integer> op21 = numbers.stream().max(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println("제일 큰 숫자 : " + op21.get());
        System.out.println("\n========================================");

        System.out.println("8-2. max 최대값");
        Optional<Integer> op22 = numbers.stream().max((o1, o2) -> o1.compareTo(o2));
        System.out.println("제일 큰 숫자 : " + op22.get());
        System.out.println("\n========================================");


        System.out.println("9. findFirst 첫번째 요소 찾기");
        Integer first = numbers.stream().filter(n -> n > 5).findFirst().get();
        System.out.println("findFirst 첫번째 요소 찾기 : " + first); // 필터로 찾는 것 중에 가장 먼저 찾는걸루
        System.out.println("\n========================================");


        System.out.println("10. findAny 아무 요소 찾기");
        // 진짜로 많은 데이터를 찾을 때 사용 (한 100_000개 이상?)
        Integer any = numbers.stream().filter(n -> n > 5).findAny().get();      // 병렬로 찾음 ㄷㄷ 속도는 이게 빠름
        System.out.println("findFirst 첫번째 요소 찾기 : " + any); // 필터로 찾는 것 중에 가장 먼저 찾는걸루
        System.out.println("\n========================================");

        System.out.println("11. anyMatch 조건을 충족하는게 하나라도 있으면 ");
        boolean match01 = numbers.stream().anyMatch(n -> n > 5);
        System.out.println("조건에 따른 boolean 결과 : " + match01);
        System.out.println("\n========================================");

        System.out.println("12. AllMatch 조건을 충족하는게 하나라도 있으면 ");
//        boolean match02 = numbers.stream().allMatch(n -> n > 0); // 전부 충족하는지
        boolean match02 = numbers.stream().allMatch(n -> n > 2); // 전부 충족하는지
        System.out.println("조건에 따른 boolean 결과 : " + match02);
        System.out.println("\n========================================");

        System.out.println("13. noneMatch 조건을 충족하는게 하나라도 있으면 ");
        boolean match03 = numbers.stream().noneMatch(n -> n < 0);
        System.out.println("조건에 따른 boolean 결과 : " + match03);
        System.out.println("\n========================================");
    }
}
