package QuizTest;

import java.util.Objects;

public class Phone {
    private String name;
    private String tel;

    // 읽기 전용 : read-only (Alt + Ins + Getter)

    public String getName() {
        return name;
    }

    public String getTel() {
        return tel;
    }

    // 쓰기 전용 : write-only (Alt + Ins + Setter)

    public void setName(String name) {
        this.name = name;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    // 기본 생성자 : Alt + Ins + Constructor
    public Phone(String name, String tel) {
        this.name = name;
        this.tel = tel;
    }

    // 얜 뭐지
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return Objects.equals(name, phone.name) && Objects.equals(tel, phone.tel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, tel);
    }
}
