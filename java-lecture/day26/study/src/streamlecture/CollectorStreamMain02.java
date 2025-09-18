package streamlecture;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorStreamMain02 {
    public static void main(String[] args) {
        List<String> names = List.of("Apple", "Banana", "Orange", "Avocado", "Blueberry", "Cherry", "Mango", "Melon");
        List<Integer> tags = List.of(1,2,3,4,5,6,7,8);


        Map<String, List<String>> grouped =
                names.stream().collect(Collectors.groupingBy(name->name.substring(0, 1)));
        System.out.println(grouped.get("A").getFirst());

        // 참 거짓 그룹을 만들기 위한 <> 반환 Key 파라미터는 Boolean으로 Return
        Map<Boolean, List<String>> partition =
                names.stream().collect(Collectors.partitioningBy(name->name.startsWith("A")));
        System.out.println(partition);



        List<Integer> numbers = List.of(1,2,3,4,5,6);
        Map<Boolean, List<Integer>> partitioned =
                numbers.stream().collect(Collectors.partitioningBy(n->n%2==0)); // partition은 true false
        System.out.println(partitioned);




    }
}
