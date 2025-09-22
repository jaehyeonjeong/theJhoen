package chapter;

public class InsertionSort {
    // 평균 수행 시간이 O(n^2)인 알고리즘

    // 각 요소가 다른 요소와 평균 한번 이상씩 비교하여 정렬

    // InsertSort 구현 유의 사항
    // 이미 정렬된 상태의 요소에 새로운 요소를 추가할 때 정렬하여 추가하는 개념
    // 두 번재 요소부터 이전 요소들과 비교하면서 insert(삽입)될 위치를 찾아가며 정렬하는 알고리즘
    public static void insertionSort(int[] arr, int count) {
        // arr : 지정된 int 배열, count : 회차 수
        int temp = 0;
        int i = 0; int j = 0;   // j가

        // 0번째 인자는 볼 필요가 없으니 i는 1부터 시작하여 탐색 진행
        for(i = 1; i < count; i++) {
            temp = arr[i];
            //
            while((j > 0) && arr[j - 1] > temp) {
                arr[j] = arr[j - 1];
                j = j - 1;
            }

            arr[j] = temp;

            System.out.println("반복 - " + i);
            printSort(arr, count);
        }
    }

    private static void printSort(int[] value, int count) {
        int i = 0;
        for(i = 0; i < count; i++) {
            System.out.print(value[i] + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {80, 50, 70, 10, 60, 20, 40, 30 };

        insertionSort(arr, 8);
    }
}
