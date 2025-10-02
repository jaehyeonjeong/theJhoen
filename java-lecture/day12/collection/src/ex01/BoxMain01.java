package ex01;

public class BoxMain01 {
    public static void main(String[] args) {
        IntegerBox integerBox = new IntegerBox();
        integerBox.setValue(10);
        Integer integer = integerBox.getValue();
        System.out.println(integer);

        StringBox stringBox = new StringBox();
        stringBox.setValue("스트링 상자");
        String string = stringBox.getValue();
        System.out.println(string);
    }
}
