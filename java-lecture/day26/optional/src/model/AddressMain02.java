package model;

import java.util.Optional;

public class AddressMain02 {
    public static void main(String[] args) {
        User user01 = new User("user01", null);
        User user02 = new User("user02", new Address("장항로 27"));

        printStreet(user01);
        printStreet(user02);
    }

    private static void printStreet(User user) {
        getUserStreet(user).ifPresentOrElse(
                System.out::println,                        // 값이 있는 경우 정상데이터 출력
                () -> System.out.println("unknown")         // 값이 없는 경우 unknown 출력
        );
    }

    static Optional<String> getUserStreet(User user) {
        return Optional.ofNullable(user)
                .map(User::getAddress)         // user.getAddress() 처리
                .map(Address::getStreet);

//        return Optional.ofNullable(user)
//                .map(u->u.getAddress())         // user.getAddress() 처리
//                .map(a->a.getStreet());
    }
}
