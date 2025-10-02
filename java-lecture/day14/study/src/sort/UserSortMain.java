package sort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class UserSortMain {
    public static void main(String[] args) {
        User user01 = new User("aaa", 30);
        User user02 = new User("bbb", 20);
        User user03 = new User("ccc", 10);

        User user[] = {user01, user02, user03};
        System.out.println(Arrays.toString(user));
        Arrays.sort(user);
        System.out.println(Arrays.toString(user));
    }
}
