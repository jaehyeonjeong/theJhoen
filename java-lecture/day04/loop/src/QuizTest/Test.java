package QuizTest;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int arr1[] = {1,2,3,4};
        int arr2[] = Arrays.copyOf(arr1, 10);
        System.out.println(Arrays.toString(arr2));
        int arr3[] = Arrays.copyOf(arr1, 3);
        System.out.println(Arrays.toString(arr3));
    }
}
