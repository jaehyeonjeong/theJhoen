package lambda;

public class GenericMain03 {
    public static void main(String[] args) {
        GenericFunction<String, String> upperCase = String::toUpperCase;

        String result01 = upperCase.apply("hello");
        System.out.println("result01 === " + result01);

        GenericFunction<Integer, Integer> square = generic -> generic * generic;

        Integer result02 = square.apply(9);
        System.out.println("result02 === " + result02);

        GenericFunction<Integer, Boolean> isEven = num ->num%2 == 0;
        Boolean result03 = isEven.apply(3);
        System.out.println("result03 === " + result03);
        // 자바에서 기본적으로 제공(지원)하는 함수형 인터페이스가 있다.
    }

    // 같이 일하는 개발자들이 함수형 인터페이스를 만들어서 사용해야한다.
    // Generic 함수 인터페이스는 받는 타입과 결과타입이 다를 수 있기 때문에 두개로 만듦
    @FunctionalInterface
    interface GenericFunction<T, R> {       //매개변수 : T, 리턴 타입 : R
        R apply(T generic);
    }

    // 새로운걸 계속 만들수는 없는 노릇이고,
}
