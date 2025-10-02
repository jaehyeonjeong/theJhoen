package study;

// 인터페이스 1
interface Animal {
    public abstract void cry();
}

// 인터페이스 2
interface Pet {
    public abstract void play();
}

// 일반 부모 클래스
class Tail {
    Tail(){
        System.out.println("꼬리를 가지고 있지요.");
    }
}

public class Cat extends Tail implements Animal, Pet {
    Cat() {
       super();
    }

    public void cry(){
        System.out.println("고양이 울음소리는 냐옹이 아니야.");
    }

    public void play() {
        System.out.println("그냥 잠이나 잘래");
    }

    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.cry();
        cat.play();
    }
}
