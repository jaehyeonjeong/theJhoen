package lambdastream;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class ListLambdaStream {
    public static void main(String[] args) {
        Optional<Object> names;
        List<String> yeah = List.of("apple", "banana", "ornge");

        Stream<String> stream = yeah.stream()
                .filter(name -> name.contains("a"));

        System.out.println(stream.toList());
    }
}
