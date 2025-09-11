package comparable;

import sort.User;

import java.util.Comparator;

public class IdComparable implements  Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        return o1.getId().compareTo(o2.getId());
    }
}
