package Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 1. 클래스를 final로 선언
public final class Immutable {

    // 2. 모든 클래스 변수를 private와 final로 선언
    private final int age;
    private final String name;
    private final List<String> list;

    // 4. 참조에 의해 변경가능성이 있는 경우 방어적 복사를 이용하여 전달
    private Immutable(int age, String name) {
        this.age = age;
        this.name = name;
        this.list = new ArrayList<>();
    }

    // 3. 객체를 생성하기 위한 생성자 또는 정적 팩토리 매소드를 추가
    public static Immutable of(int age, String name) {
        return new Immutable(age, name);
    }

    // get 허용, set 금지
    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public List<String> getList() {
        // 원본 리스트 유지
        return Collections.unmodifiableList(list);
    }


}
