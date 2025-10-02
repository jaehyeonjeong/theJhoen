package model;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

public class AddressMain03 {
    public static void main(String[] args) {
        User user01 = new User("user01", null);
        User user02 = new User("user02", new Address("장항로 27"));

        printStreet(user01);
        printStreet(user02);
    }

    private static void printStreet(User user) {
        getUserStreet(user).ifPresentOrElse(
                // 메서드 참조로 들어가는 경우
                new Consumer<String>() {
                    @Override
                    public void accept(String s) {
                        System.out.println(s);
                    }
                },                        // 값이 있는 경우 정상데이터 출력
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("unknown");
                    }
                }     // 값이 없는 경우 unknown 출력
        );
    }

    // Optional은 매서드 리턴값으로 사용하는게 졸다.
    // get()은 직접 사용 금지.. null을 리턴할 수 있기 떄문
    static Optional<String> getUserStreet(User user) {
        return Optional.ofNullable(user)
                // 익명 함수 원형 (메서드 참조)
                .map(new Function<User, Address>() {
                    @Override
                    public Address apply(User user) {
                        return user.getAddress();
                    }
                })         // user.getAddress() 처리
                .map(new Function<Address, String>() {
                    @Override
                    public String apply(Address address) {
                        return address.getStreet();
                    }
                });
    }
}
