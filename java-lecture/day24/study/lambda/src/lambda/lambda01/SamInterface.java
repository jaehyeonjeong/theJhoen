package lambda.lambda01;

// 함수형 인터페이스라고 한다.
@FunctionalInterface        // 람다형 함수를 만들 때 어노테이션을 붙여주면 실수를 줄일 수 있다.
public interface SamInterface {
    void run();
}
