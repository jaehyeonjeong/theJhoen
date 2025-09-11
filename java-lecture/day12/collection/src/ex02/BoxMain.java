package ex02;

import animals.Animal;
import animals.Cat;
import animals.Dog;

public class BoxMain {
    public static void main(String[] args) {
        Box<Dog> box = new Box<>();
        box.setValue(new Dog("멍머이", 20));
        Dog dog = box.getValue();
        dog.sound();
        System.out.println(dog.getName());
        System.out.println(dog.getSize());

        Box<Animal> animalBox = new Box<>();
        animalBox.setValue(new Cat("들짐승 고양이", 30));
        Animal animal = animalBox.getValue();
        animal.sound();
        System.out.println(animal.getName());
        System.out.println(animal.getSize());
    }
}
