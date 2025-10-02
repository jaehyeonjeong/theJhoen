package Inter;

public interface MobilePhoneInterface extends PhoneInterface {
    default void sendSMS() {
        System.out.println("문자를 보냅니다.");
    }

    ;

    default void receiveSMS() {
        System.out.println("문자를 받습니다.");
    }

    ;
}
