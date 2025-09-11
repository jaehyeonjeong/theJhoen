package zoo;

// Animal 인터페이스
interface Animal {
    void bark();
}

// Dog 클래스: Animal 인터페이스 구현
class Dog implements Animal {
    @Override
    public void bark() {
        System.out.println("개가 짖습니다.");
    }
}

// Zoo 클래스: Animal을 받아서 동작
public class Zoo {
    private Animal animal;  // Animal 타입 필드 선언

    public Zoo(Animal animal) {
        this.animal = animal;
    }

    public void openZoo() {
        animal.bark();
    }
}
