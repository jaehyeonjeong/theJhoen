import java.util.Arrays;
import java.util.function.IntUnaryOperator;

public class ArraysTest {
    public static void main(String[] args) {
        // Arrays
        // collection, list를 많이 씀
        // java array는 매서드가 없다. 불변(immutable)이다.
        String[] strFruits = {"사과", "배", "포도"};
        // Arrays는 java array를 보충하기 위해 나온 util 객체이다.

        Arrays.fill(strFruits, "기타");   // fill 매소드를 ctrl + 좌클릭 하여 코드가 적혀있는 방식을 찾아볼 수 있다.

        System.out.println(Arrays.toString(strFruits));

        int nArray[] = new int [5];
//        Arrays.fill(nArray, 1);
//        Arrays.fill(nArray, 1, 4, 100);
        // 함수형 인터페이스는 하나만 쓸 수 있기 떄문에 람다식으로 줄일 수 있다.
        Arrays.setAll(nArray, operand -> 1 - operand); // 규칙을 가지고 채우기 위함

        System.out.println(Arrays.toString(nArray));

        // java 객체는 new를 생성자 함수를 통해서 Heap 메모리에 올려놓고 사용해야 한다.
        // static이 붙어 있으면 따로 선언하지 않고 사용이 가능하다. 단, 너무 많이 쓰면 위험하다.
        // Math같은 경우도 선언하지 않고 사용가능하므로 Static 영역에 있다고 본다.

        int nCopyArray[] = Arrays.copyOf(nArray, nArray.length); // 복사 및 길이에 따른 복사 가능
        // 정해진 배열의 길이만큼 복사하는 방법
        // copyOf를 사용하면 다른메모리를 공유하는 배열 변수를 만들 수 있다.
        nArray[2] = 100;
        Arrays.sort(nArray);
        System.out.println(Arrays.toString(nArray) + "// 오름차순 정렬");

        System.out.println(Arrays.toString(nCopyArray));

    }
}
