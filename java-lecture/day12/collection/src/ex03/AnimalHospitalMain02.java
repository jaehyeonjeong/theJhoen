package ex03;

import animals.Cat;
import animals.Dog;

public class AnimalHospitalMain02 {
    public static void main(String[] args) {
        AnimalHospital dogHospital = new AnimalHospital();
        AnimalHospital catHospital = new AnimalHospital();
        Dog dog = new Dog("멍멍이", 20);
        Cat cat = new Cat("야몽이", 30);
        dogHospital.set(dog);
        catHospital.set(cat);
        dogHospital.check();
        catHospital.check();
    }
}
