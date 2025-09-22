package collectfunction;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsChangeMain {
    public static void main(String[] args) {
        // Collectors.toList()
        Stream<String> stream = Stream.of("1", "2", "3", "4", "5");
        // 스트림 객체를 리스트로 전환
        List<String> streamToList = stream.toList();
        System.out.println("streamToList = " + streamToList);

        // Collectors.toMap()
        Stream<String> stream02 = Stream.of("1", "2", "3", "4", "5");
        Map<Integer, String> streamToMap =
                stream02.collect(Collectors.toMap(str->
                        Integer.parseInt(str),  // 키 값이 Integer이기 때문에 Integer로 전환
                        str->"\"" + str + "\""));
        System.out.println("streamToMap = " + streamToMap);

        // List나 Map이 아닌 컬렉션으로 변환
        Stream<String> stream03 = Stream.of("1", "2", "3", "4", "5");
        ArrayList<String> streamToArrayList =
                stream03.collect(Collectors.toCollection(()->new ArrayList<>()));
        System.out.println("streamToArrayList = " + streamToArrayList);

        // 배열로 반환, Array는 Collector는 아니지만 toArray를 사용해서 반환할 수 있다.
        Stream<String> stream04 = Stream.of("1", "2", "3", "4", "5");
        Object[] objects = stream04.toArray();      // Object는 배열 변환시 람다식 x
        System.out.println(Arrays.toString(objects));

        Stream<String> stream05 = Stream.of("1", "2", "3", "4", "5");
        // 특정한 형을 원하는 경우 람다식을 작성해야 한다.
//        String[] strings = stream05.toArray(i->new String[i]);
        String[] strings = stream05.toArray(String[]::new);
        System.out.println(Arrays.toString(strings));
    }
}
