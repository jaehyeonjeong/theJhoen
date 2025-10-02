package lambda.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class GenericFilter {
    // 파라미터는 리스트와 함수형 인터페이스를 받아서 리스트 내에 있는 단어들 중 메소드를 통해 판별
    public static List<String> filter (List<String> stringList, Predicate<String> function){
        // 새로운 리스트를 만듦
        List<String> newStringList = new ArrayList<>();

        // Integer filter와 마찬가지로 조건을 충족하는 경우에만 List에 추가
        for(String s : stringList) {
            if(function.test(s)){
                newStringList.add(s);
            }
        }

        // 추가된 리스트 반환
        return newStringList;
    }
}
