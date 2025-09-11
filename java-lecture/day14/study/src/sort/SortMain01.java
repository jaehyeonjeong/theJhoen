package sort;

import java.util.Arrays;

public class SortMain01 {
    public static void main(String[] args) {
        Integer[] array = {3, 2, 1, 6, 4, 7, 9, 0};
        System.out.println(Arrays.toString(array));

        System.out.println("기본 정렬");
        Arrays.sort(array); // 배열 내에 있는 데이터를 오름차순으로 변경
        System.out.println(Arrays.toString(array));

        // 내림차순으로 변경하는 방법
        AscComparator ascComparator = new AscComparator();
        Arrays.sort(array,ascComparator);
        System.out.println(Arrays.toString(array));

        // 오름차순으로 변경하는 방법
        Arrays.sort(array, new DescComparator());
        System.out.println(Arrays.toString(array));
    }
}
