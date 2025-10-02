package review01;

public class AnimalPolyMain01 {
    public static void main(String[] args) {
        Dog dog = new Dog();

        Cat cat = new Cat();

        Cow cow = new Cow();

        Bird bird = new Bird();

        Chicken chicken = new Chicken();

        soundAnimal(dog);
        soundAnimal(cat);
        soundAnimal(cow);
        soundAnimal(bird);
        flyAnimal(bird);
        flyAnimal(chicken);


    }

    static void soundAnimal(Animal animal) {
        System.out.println("동물이 소리를 냅니다");
        animal.sound();
        System.out.println("동물이 소리를 멈춥니다.");
    }

    // 인터페이스를 받을 수 있다.
    static void flyAnimal(Fly animal) {
        System.out.println("동물이 소리를 냅니다");
        animal.fly();
        System.out.println("동물이 소리를 멈춥니다.");
    }
}
