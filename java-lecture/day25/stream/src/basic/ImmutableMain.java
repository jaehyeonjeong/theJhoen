package basic;

import java.util.List;

public class ImmutableMain {
    public static void main(String[] args) {
        List<Integer> originList = List.of(1,2,3,4,5,6,7,8,9);
        System.out.println("originList = " + originList);
        List<Integer> filteredList = originList.stream()
                .filter(num->num%2==0)
                .toList();
        // 가공한 것 처럼 만들어 보여도 새로 만든 것과 같은 효과를 누림
        System.out.println("filteredList = " + filteredList);
        System.out.println("originList = " + originList);
    }
}
