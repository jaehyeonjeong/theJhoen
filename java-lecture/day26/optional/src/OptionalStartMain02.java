import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OptionalStartMain02 {

    private static final Map<Long, String> map = new HashMap<>();
    static {
        map.put(1L, "Kim");
        map.put(2L, "Jung");
        map.put(3L, "Park");
    }

    static void findAndPrint(Long id) {
        Optional<String> optionalName = findNameById(id);
        // 첫번째와는 다르게 Optional 구문을 추가해서 if-else 하지 않아도 조건처리처럼 나온다.
        String name = optionalName.orElse("UNKNOWN");
        System.out.println(id + " : " + name.toUpperCase());
    }

    static Optional<String> findNameById(Long id) {
        String findName = map.get(id);
        // null을 어떻게 처리할건지 강제 : 사용하지 않으면 예외가 발생
        return Optional.ofNullable(findName);
//        Optional<String> optionalName = Optional.ofNullable(findName);
//        return optionalName;
    }

    public static void main(String[] args) {
        findAndPrint(3L);
        findAndPrint(4L);
    }
}
