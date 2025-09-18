package review01;

public class AnimalPolyMain01 {
    public static void main(String[] args) {
        Dog dog = new Dog();

        Cat cat = new Cat();

        Cow cow = new Cow();

        soundAnimal(dog);
        soundAnimal(cat);
        soundAnimal(cow);

        
    }

    static void soundAnimal(Animal animal) {
        System.out.println("동물이 소리를 냅니다");
        animal.sound();
        System.out.println("동물이 소리를 멈춥니다.");
    }
}
