package lambda;

import java.io.PrintStream;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;

public class BiMain {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        System.out.println(add.apply(20, 12));

        // Cousumer 반환 (x), 입력(o)
        BiConsumer<String, Integer> repeat = (c, n) -> {
            for (int i = 0; i < n; i++) {
                System.out.print(c + " ");
            }
            System.out.println();
        };

        repeat.accept("*", 10);

        // Predicate 반환(boolean), 입력(o)
        BiPredicate<Integer, Integer> isGreater = (a, b) -> a > b;
        System.out.println(isGreater.test(10, 5));

        BinaryOperator<Integer> add01 = (a, b) -> a + b;
        System.out.println(add01.apply(2, 20));
    }
}
