package ex03;

import animals.Cat;
import animals.Dog;

public class AnimalHospitalMain03 {
    public static void main(String[] args) {
        AnimalHospital02<Dog> dogAnimalHospital01 = new AnimalHospital02<>();
        AnimalHospital02<Cat> catAnimalHospital01 = new AnimalHospital02<>();
        Dog dog = new Dog("멍멍이", 20);
        Cat cat = new Cat("야몽이", 30);
        dogAnimalHospital01.set(dog);
        catAnimalHospital01.set(cat);
        dogAnimalHospital01.check();
        catAnimalHospital01.check();

        // Integer을 써도 타입 안정성을 보장박음
//        AnimalHospital02<Integer> catAnimalHospital02 = new AnimalHospital02<>();
//        AnimalHospital02<Cat> catAnimalHospital02 = new AnimalHospital02<>();

    }
}
