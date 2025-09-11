package ex03;

import animals.Animal;

public class AnimalHospital01 <T>{
    private T animal;

    public void set(T animal) {
        this.animal = animal;
    }

    public void check() {
        animal.toString();
        animal.equals(null);
    }

    public T bigger(T target) {
        return null;
    }
}
