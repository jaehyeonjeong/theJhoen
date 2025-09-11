package basic.checked;

public class MyCheckedException extends Exception{
    // 예외는 Exception 까지만 받는다.
    // Exception을 상속받으면 자바에서 지원하는 모든 예외를 처리할 수 있다.
    // 강제성을 부여(extends Exception을 무조건 해야한다);
    // 예외, 오류(Throwable은 에러까지 처리한다. 프로그래머가 어떻게 할 수 없다.)
    public MyCheckedException(String message) {
        super(message);
    }
}
