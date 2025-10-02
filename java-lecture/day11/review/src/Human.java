// 자바의 특징
// 자바는 상속을 지원 단일 상속만 가능
public final class Human extends Animal{

    void work() {
        System.out.println("일을 합니다.");
    }

    void study() {
        System.out.println("공부를 합니다.");
    }

    @Override
    void sound() {
        System.out.println("이야기를 한다.");
    }
}
