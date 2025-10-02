package collections;

import java.util.*;

// iterator : 순회 => foreach 문과 같다.
public class iteratorTest {
    public static void main(String[] args) {
//        String[] strArray = {"apple", "apple", "apple", "banana", "peach"};
//        List<String> arrayList = new ArrayList<>(Arrays.asList(strArray));
//        for (int i = 0; i < arrayList.size(); i++) {
//            System.out.println(arrayList.get(i));
//        }
//
//        System.out.println("==================================");
//        Iterator<String> iterator = arrayList.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }

        // 랜덤한 1~100 사이의 숫자를 가지는 arrayList 100개를 만들고 그 합을 구하시오.
        List<Integer> integerList = new ArrayList<>();
        int nSum = 0;
        for (int i = 0; i < 100; i++) {
//            int nNumber = (int) (Math.random() * 100) + 1;
            Random random = new Random();
            int nNumber = random.nextInt(100) + 1;
            integerList.add(nNumber);
        }

        Iterator<Integer> iterator1 = integerList.iterator();

        while (iterator1.hasNext()) {
            nSum += iterator1.next();
        }
        System.out.println("총 합 : " + nSum);

        System.out.println("==================================");

        String[] strArray = {"apple", "banana", "peach"};
        List<String> arrayList = new ArrayList<>(Arrays.asList(strArray));

//        for (String str : arrayList) {
//            if (str.equals("apple")) {
//                System.out.println("apple이 있다.");
////                arrayList.remove(str);    // 제거 안됨 예외 발생
//            }
//        }
//        System.out.println(arrayList);

        // Iterator 상에서만 데이터 제거가 가능하다.
        Iterator<String> stringIterator = arrayList.iterator();

        while (stringIterator.hasNext()) {
            String str = stringIterator.next();

            if (str.equals("apple")) {
                stringIterator.remove();
            }
        }
        System.out.println(arrayList);

    }

}
