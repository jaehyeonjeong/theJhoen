package collection;

import com.sun.source.tree.Tree;
import doubleclass.inner.InnerOuterMain;

import java.util.*;
import java.util.stream.Collectors;

public class SetMain {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("A");
        set.add("A");
        set.add("A");
        set.add("A");
        set.add("B");
        set.add("B");
        set.add("C");
        set.add("C");
        set.add("C");
        set.add("D");
        set.add("D");
        set.add("E");
        set.add("A");
        set.add("A");

        System.out.println(set.size()); // Set은 중복을 허용하지 않기 때문에 add한 것보다 적게 나옴

        for (String s : set) {
            System.out.println(s);
        }

        set.forEach(System.out::print);

        //Iterator<String> iterator = set.iterator();
        //        while(iterator.hasNext()) {
        //            System.out.println(iterator.next());
        //        }

        // 퀴즈
        // {30, 20, 10,10};; Set으로 만들자
        System.out.println();
        Integer[] nArr = {30,20,20,10,10};
        // 입력한 순서대로 보장받는 객채는 LinkedHashSet
        Set<Integer> integers = new LinkedHashSet<>(Arrays.asList(nArr));
        Set<Integer> integers2 = new TreeSet<>(Arrays.asList(nArr));

        Set<Integer> integers1 = Arrays.stream(nArr).collect(Collectors.toSet());

        System.out.println(integers);
        System.out.println(integers1);
        System.out.println(integers2);  // 오름차순으로 정렬하는 Set객체

        // 람다 스레드 optonal
    }
}
