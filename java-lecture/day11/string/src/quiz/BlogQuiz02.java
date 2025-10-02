package quiz;

public class BlogQuiz02 {
    //    2.String[] arr = {"hello", "java", "jvm", "spring", "jpa"} 에 있는 모든 문자려의 길이의
//    합을 구하는 코드를 작성하시오.
//
//    실행결과
//    hello:5
//    java:4
//    jvm:3
//    spring:6
//    jpa:3
//    sum = 21
    public static void main(String[] args) {
        String[] arr = {"hello", "java", "jvm", "spring", "jpa"};
        int nArrLength;
        int nArrSumLength = 0;

        for (int i = 0; i < arr.length; i++) {
            nArrLength = arr[i].length();
            System.out.println(arr[i] + " : " + nArrLength);
            nArrSumLength += nArrLength;
        }

        System.out.println("sum = " + nArrSumLength);
    }
}
