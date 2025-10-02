package comparable;

import sort.User;

import java.util.*;

public class SortMain03 {
    public static void main(String[] args) {
        User user01 = new User("ccc", 30);
        User user02 = new User("aaa", 20);
        User user03 = new User("bbb", 10);

        Set<User> treeSet01 = new TreeSet<>();
        treeSet01.add(user01);
        treeSet01.add(user02);
        treeSet01.add(user03);

        System.out.println("Comparable 기본 정렬");
        System.out.println(treeSet01);      // TreeSet 같은 경우에는 Comparable을 따로 구현해야한다.


        Set<User> treeSet02 = new TreeSet<>(new IdComparable());
        treeSet02.add(user01);
        treeSet02.add(user02);
        treeSet02.add(user03);
        System.out.println("Id 기본 정렬");
        System.out.println(treeSet02);      // TreeSet 같은 경우에는 Comparable을 따로 구현해야한다.
        // TreeSet을 만들때에는 반드시 정렬 구현이 필요하다.
    }
}
