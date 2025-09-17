package lambda;

import java.util.function.Consumer;

public class ConsumerMain01 {
    public static void main(String[] args) {
        Consumer<String> consumer01 = string -> System.out.println(string);

        consumer01.accept("hello lambda");

        Consumer<String> consumer02 = new Consumer<String>() {
            @Override
            public void accept(String string) {
                System.out.println(string);
            }
        };

        consumer02.accept("hello world");
    }
}
