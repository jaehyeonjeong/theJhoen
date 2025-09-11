package ex03;

import animals.Animal;

public class AnimalHospital {
    private Animal animal;

    public void set(Animal animal) {
        this.animal = animal;
    }

    public void check() {
        System.out.println("동물이름 : " + animal.getName());
        System.out.println("동물크기 : " + animal.getSize());
        animal.sound();
    }

    public Animal bigger(Animal target) {
        return animal.getSize() > target.getSize() ? animal : target;
    }
}
