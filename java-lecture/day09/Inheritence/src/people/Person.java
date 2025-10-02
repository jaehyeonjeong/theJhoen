package people;

public class Person {
    String name;
    String id;

    public Person(String name) {
        this.name = name;
    }

    public void introduce() {
        System.out.println("나는 사람입니다.");
    }
}
