package study;

public interface interfaceName {                // 인터페이스 이름
    public static final String typeName = "값";  // 1. final 상수 이름
    public abstract String strMethodName(String string);    // 2. 추상 메서드

    int MAX_VOLUME = 10;    // public static final 생략 가능
    int MIN_VOLUME = 10;

    void turnOn();      // public abstract 생략 가능
    void turnOff();
    void changeVolume(int volume);
    void changeChannel(int channel);

    default void ipAddress() {};    // abstract로 추상화하지 않고, 구현을 미리 할 수 있음
}
