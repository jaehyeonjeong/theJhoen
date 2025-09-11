package comparable;

import sort.User;

import java.util.Arrays;

public class IdComparableMain {
    public static void main(String[] args) {
        User user01 = new User("ccc", 30);
        User user02 = new User("aaa", 20);
        User user03 = new User("bbb", 10);

        User user[] = {user01, user02, user03};
        System.out.println(Arrays.toString(user));
        Arrays.sort(user);
        System.out.println(Arrays.toString(user));
        Arrays.sort(user, new IdComparable());
        System.out.println(Arrays.toString(user));
    }
}
