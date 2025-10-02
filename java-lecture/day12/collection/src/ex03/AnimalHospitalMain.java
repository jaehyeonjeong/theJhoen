package ex03;

import animals.Cat;
import animals.Dog;

public class AnimalHospitalMain {
    public static void main(String[] args) {
        DogHospital dogHospital = new DogHospital();
        CatHospital catHospital = new CatHospital();
        Dog dog = new Dog("멍멍이", 20);
        Cat cat = new Cat("야몽이", 30);
        dogHospital.set(dog);
        catHospital.set(cat);
        dogHospital.check();
        catHospital.check();
    }
}
