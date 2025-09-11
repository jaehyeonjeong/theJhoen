public class MethodOverloading {
    int getSum(int a, int b) {
        return a + b;
    }

    int getSum(int a, int b, int c) { // 같은 함수명 다른 인자의 개수
        return a + b + c;
    }

    double getSum(double a, int b) { // 오버로딩에서는 함수의 리턴타입을 따지지 않는다
        return a + b;   // 단, 매개인자의 타입이 다른경우에는 오버로딩을 인정한다.
    }

    // 규칙
    // 1, 매개변수의 갯수 또는 타입이 서로 달라야 한다.
    // 2. 리턴값은 해당하지 않는다.
    // 3.
}
