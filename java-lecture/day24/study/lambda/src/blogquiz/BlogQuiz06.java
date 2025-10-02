package blogquiz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BlogQuiz06 {

    public static List<String> map(List<String> list, StringFunction func) {
        // 코드 작성
        List<String> newList = new ArrayList<>();
        for(String string : list){
            String s = func.apply(string);
            newList.add(s);
        }
        return newList;
    }

    //StringFunction 은 함수형 인터페이스이며, String apply(String s); 같은 메서드를 가진다.
    public interface StringFunction {
        String apply(String s);
    }

    public static void main(String[] args) {
        List<String> words = List.of("hello", "java", "lambda");
        System.out.println("원본 리스트: " + words);

        // 1. 대문자 변환
        StringFunction stringFunction01 = new StringFunction() {
            @Override
            public String apply(String s) {
                return s.toUpperCase();
            }
        };

        System.out.print("대문자 변환 결과 : ");
        System.out.println(map(words, stringFunction01));

        // 2. 앞뒤에 *** 붙이기 람다로 작성
        System.out.print("특수문자 데코 결과 : ");
        StringFunction stringFunction02 = s -> "***" + s + "***";
        System.out.println(map(words, stringFunction02));
    }
}
