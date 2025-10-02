package lambda;


import java.util.Random;
import java.util.function.Supplier;

public class SupplierMain01 {
    public static void main(String[] args) {
        Supplier<Integer> supplier01 = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return new Random().nextInt(10);
            }
        };

        System.out.println("supplier01.get() === " + supplier01.get());

        Supplier<Integer> supplier02 = () -> new Random().nextInt(200);
        System.out.println("supplier02.get() === " + supplier02.get());
    }
}
