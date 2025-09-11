package comparable;

import sort.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserSortMain01 {
    public static void main(String[] args) {
        User user01 = new User("ccc", 30);
        User user02 = new User("aaa", 20);
        User user03 = new User("bbb", 10);

        List<User> userList = new ArrayList<>();
        // 기본 정렬
        userList.add(user01);
        userList.add(user02);
        userList.add(user03);
        System.out.println("기본정렬");
        System.out.println(userList);
        System.out.println("Comparable 기본 정렬");
//        userList.sort(null);        // 리스트(컬렉션)안에도 sort가 있다.
        Collections.sort(userList);
        System.out.println(userList);

        System.out.println("Id 정렬");
        userList.sort(new IdComparable());
        // Collections.sort(userList, new IdComparable()); // 바로 위의 코드와 동일한 동작을 보임.
        System.out.println(userList);

    }
}
