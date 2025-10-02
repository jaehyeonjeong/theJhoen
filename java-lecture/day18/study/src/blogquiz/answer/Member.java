package blogquiz.answer;

import java.io.Serializable;

// 직렬화 : 객체를 byte로 바꿈, 객체는 network로 전송이 불가능하다. byte만 전송이 가능하다.
// 역직렬화 ; byte를 객체로 복원하는 작업을 말한다.

public class Member implements Serializable{
    // Serializeable을 implement하면 자동으로 직렬화 할 수 있는 객체라고 표시한다.
    private String ID;
    private String name;
    private int Age;

    public Member(String ID, String name, int age) {
        this.ID = ID;
        this.name = name;
        Age = age;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    @Override
    public String toString() {
        return "Member{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", Age=" + Age +
                '}';
    }
}
