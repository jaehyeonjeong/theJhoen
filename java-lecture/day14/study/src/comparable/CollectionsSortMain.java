package comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsSortMain {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        integerList.add(5);
        integerList.add(6);
        integerList.add(7);
        integerList.add(8);
        integerList.add(9);
        Integer max = Collections.max(integerList);
        System.out.println(max);
        Integer min = Collections.min(integerList);
        System.out.println(min);
        Collections.shuffle(integerList);
        System.out.println(integerList);
    }
}
