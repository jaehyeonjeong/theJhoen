package abs;

public class AnimalMain {
    public static void main(String[] args) {
        // 상속 받은 부모 클래스를 사용하여 abstract된 항목들을 받을 수 있다.
        // (부모 타입으로 자식을 받음)
        Animal cat = new Cat();
        cat.cry(); // 동적 바인딩
        Animal dog = new Dog();
        dog.cry(); // 동적 바인딩
    }
}
