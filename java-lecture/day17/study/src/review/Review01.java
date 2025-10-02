package review;

public class Review01 {
    public static void main(String[] args) {
        // 자바는 예외 상황
        // 1. 강제성을 띄우는 checked exception
        // 2. 강제성을 띄우지 않는 unchecked exception

        try {
            int resut = 10 / 0;     // 오류(Error)는 아니다. 컴파일은 되니까
            // 논리적 오류인 경우에는 RunTimeException으로 catch 할 수 있다.

        } catch (/*여기에 터질것으로 예상되는 예외를 작성 위의 경우는 ArithmethicException*/Exception e) {
            // 예외가 예상이 가지 않는 경우는 RuntimeException이나 Exception인 최상위 객체로 보낼 수 있다.
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            System.out.println("여기는 항상 실행됩니다.");
        }

    }
}
