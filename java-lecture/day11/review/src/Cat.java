public class Cat extends Animal{


    void grooming() {
        System.out.println("그루밍을 한다.");
    }

    @Override
    void sound() {
        System.out.println("고양이 소리");
    }
}
