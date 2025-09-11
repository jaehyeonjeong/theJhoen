package ex03;

import animals.Animal;

public class AnimalHospital02 <T extends Animal> {
    private T animal;

    public void set(T animal) {
        this.animal = animal;
    }

    public void check() {
        System.out.println("동물이름 : " + animal.getName());
        System.out.println("동물크기 : " + animal.getSize());
        animal.sound();
    }

    public T bigger(T target) {
        return animal.getSize() > target.getSize() ? animal : target;
    }
}
