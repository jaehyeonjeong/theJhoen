package iter;

import com.sun.source.doctree.SeeTree;

import java.util.*;

public class IterableMain {
    public static void printAll(Iterator<Integer> integerIterator) {
        System.out.print("iterator = " + integerIterator.getClass() + "\n");
        while(integerIterator.hasNext()) {
            System.out.print(integerIterator.next() + " ");
        }
    }

    public static void foreach(Iterable<Integer> integerIterable) {
        System.out.print("iterable = " + integerIterable.getClass() + "\n");
        for(Integer i : integerIterable) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();

        integerList.add(1);
        integerList.add(2);
        integerList.add(3);

        printAll(integerList.iterator());
        System.out.println();
        foreach(integerList);// 모든 컬렉션에는 iterable을 구현할 수 있다.
        System.out.println();

        Set<Integer> integerSet = new HashSet<>();
        integerSet.add(1);
        integerSet.add(2);
        integerSet.add(3);

        printAll(integerSet.iterator());
        System.out.println();
        foreach(integerSet);
        System.out.println();
    }
}
