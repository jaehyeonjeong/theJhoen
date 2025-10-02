package review;

public class Exception02 {
    public static void main(String[] args) {
        int[] numbers  = {1,2,3,4,5};
        try {
            System.out.println(numbers[7]); // 예측가능

        } catch (ArrayIndexOutOfBoundsException e) {        // RunTime이나 Exception 으로 잡을 수 있음
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
