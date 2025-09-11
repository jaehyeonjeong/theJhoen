package sort;

import java.util.Comparator;

public class DescComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        System.out.println("o1 ==== " + o1 + "/ o2 ==== " + o2);
        if (o1 > o2) {
            return 1;
        } else if (o1 < o2) {
            return -1;
        } else {
            return 0;
        }
    }
}
