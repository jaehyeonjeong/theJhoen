package blogquiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BlogQuiz05 {
    //5.
    //1. 정수 리스트가 주어졌을 때, 특정 조건에 맞는 요소들만 뽑아내는 filter 함수를 직접 만들어보자.
    //2. filter(List<Integer> list, MyPredicate predicate) 형식의 정적 메서드를 하나 작성한다.
    //MyPredicate 는 함수형 인터페이스이며, boolean test(int value); 같은 메서드를 가진다.
    //3. main() 에서 예시로 다음과 같은 상황을 실습해보자.
    //	리스트: [-3, -2, -1, 1, 2, 3, 5]
    //	조건 1: 음수(negative)만 골라내기
    //	조건 2: 짝수(even)만 골라내기
    //	예시 실행
    //	원본 리스트: [-3, -2, -1, 1, 2, 3, 5]
    //	음수만: [-3, -2, -1]
    //	짝수만: [-2, 2]
    //
    //함수형 인터페이스 예시
    //@FunctionalInterface
    //public interface MyPredicate {
    //    boolean test(int value);
    //}
    public static void main(String[] args) {
        // 원본 리스트
        List<Integer> list = new ArrayList<>(Arrays.asList(-3, -2, -1, 1, 2, 3, 5));
        System.out.println("원본 리스트 : " + list);

        MyPredicate myPredicate01 = value -> {
            if(value < 0) return true;
            return false;
        };

        MyPredicate myPredicate02 = value -> {
            if(value % 2 == 0) return true;
            return false;
        };

        System.out.print("음수만 : ");
        filter(list, myPredicate01);
        System.out.print("짝수만 : ");
        filter(list, myPredicate02);
    }

    public interface MyPredicate{
        boolean test(int value);
    }

    public static void filter(List<Integer> list, MyPredicate predicate){
        List<Integer> newList = new ArrayList<>();
        for(Integer integer : list) {
            boolean b = predicate.test(integer);
            if(b) newList.add(integer);
        }
        System.out.println(newList);
    }
}
