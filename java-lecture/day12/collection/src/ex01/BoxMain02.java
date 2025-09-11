package ex01;

public class BoxMain02 {
    public static void main(String[] args) {
        ObjectBox integerBox = new ObjectBox();
        integerBox.setObject(10);
        System.out.println(integerBox.getObject());

        Integer integer = (Integer) integerBox.getObject();
        System.out.println(integer);

        // 그런데 오브젝트로 담기에는 부담이 크다
    }
}
