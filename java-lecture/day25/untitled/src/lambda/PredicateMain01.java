package lambda;

import java.util.function.Predicate;

public class PredicateMain01 {
    // 입력(o), 반환(boolean으로만 처리)
    public static void main(String[] args) {
        Predicate<Integer> predicate01 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer % 2 == 0;
            }
        };

        System.out.println(predicate01.test(10));


        Predicate<Integer> predicate02 = integer -> integer % 2 == 0;

        System.out.println(predicate02.test(10));

        // Function으로 구현이 가능하지만 boolean으로만 반환해서 편리함 굳이 파라미터 2개를 다 쓰지 않아도 됨

    }
}
