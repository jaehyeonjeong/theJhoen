package lambda;

public class GenericMain02 {
    public static void main(String[] args) {
        ObjectFunction objectFunction = (o) -> ((String)o).toUpperCase();
        String result01 = (String)objectFunction.apply("Hello");
        System.out.println("result01 = " + result01);

        ObjectFunction objectFunction1 = (o) -> ((int)o) * ((int)o);
        Integer result02 = (Integer) objectFunction1.apply(9);
        System.out.println("result02 = " + result02);
        // 매개 변수 1 그리고 리턴타입이 Integer, String
    }

    @FunctionalInterface
    interface ObjectFunction {
        Object apply(Object s);
    }

    // 새로운걸 계속 만들수는 없는 노릇이고,
}
