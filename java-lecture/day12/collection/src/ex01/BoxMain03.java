package ex01;

public class BoxMain03 {
    public static void main(String[] args) {
        // 제네릭의 장점은 타입이 생성시점에 정해지는게 아니라 생성시점에 타입을 결정지을 수 있음
        // 범용 타입 : 모든것을 담을 수 있음 (단 참조 타입만 들어올  수 있다.)
        GenericBox<Integer> integerGenericBox = new GenericBox<Integer>();
        // 추론 : 타입의 유추가 가능함 (위와 같은 경우는 Integer)
        integerGenericBox.setValue(10);
        Integer integer = integerGenericBox.getValue();
        System.out.println(integer);

        GenericBox<String> stringGenericBox = new GenericBox<>();
        stringGenericBox.setValue("안녕하세요");
        String string = stringGenericBox.getValue();
        System.out.println(string);
    }
}
