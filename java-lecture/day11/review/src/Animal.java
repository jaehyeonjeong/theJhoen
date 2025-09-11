public abstract class Animal {
    String name;
    int age;

    void eat() {
        System.out.println("먹이를 먹습니다.");
    }

    void sleep() {
        System.out.println("잠을 잡니다.");
    }

    // 추상 메서드 : 상속받는 자식 클래스가 구현한다.
    // 코드를 강제하기 위해 abstract를 사용
    abstract void sound();
}
