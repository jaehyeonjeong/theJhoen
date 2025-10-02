import java.util.HashMap;
import java.util.Map;

public class OptionalStartMain01 {

    private static final Map<Long, String> map = new HashMap<>();
    static {
        map.put(1L, "Kim");
        map.put(2L, "Jung");
        map.put(3L, "Park");
    }

    static void findAndPrint(Long id) {
        String name = findNameById(id);
        if(name != null) {
            System.out.println(id + " : " + name.toUpperCase());
        } else {
            System.out.println(id + " : UNKNOWN");
        }
    }

    static String findNameById(Long id) {
        return map.get(id);
    }

    public static void main(String[] args) {
        findAndPrint(4L);
    }
}
