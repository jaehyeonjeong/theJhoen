package Inter;

//
public interface PhoneInterface {
    int TIMEOUT = 10000;    // 상수

    void sendCall();

    void receiveCall();

    default void showLogo() {
        System.out.println("===LOGO===");
        System.out.println(TIMEOUT);
    }
}
