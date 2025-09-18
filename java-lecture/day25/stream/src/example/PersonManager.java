package example;

import java.util.ArrayList;
import java.util.List;

public class PersonManager {
    private Person person;

    private final List<Person> personList = new ArrayList<>();

    public PersonManager() {
    }

    public PersonManager(Person person) {
        this.person = person;
    }

    public void regiPerson(String name, int number) {
        person = new Person(name, number);
        personList.add(person);
    }

    public Person getPerson() {
        return person;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void showRegiList() {
        System.out.println("예약된 사람의 목록입니다.");

        System.out.println("============예약목록============");
        ;
        for(Person person : getPersonList()) {
            System.out.println("이름 : " + person.getName()
                    + " | 번호 : " + person.getNumber());
        }
    }
}
