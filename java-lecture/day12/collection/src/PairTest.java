public class PairTest {
    // 타입 스크립트에도 적용할 수 있다.

    public static void main(String[] args) {
        Pair<Integer, String> pair1 = new Pair<>();
        pair1.setFirst(1);
        pair1.setSecond("data");
        System.out.println(pair1.getFirst());
        System.out.println(pair1.getSecond());
        System.out.println("pair1 = " + pair1);
        Pair<String, String> pair2 = new Pair<>();  // 키 벨류
        pair2.setFirst("key");
        pair2.setSecond("value");
        System.out.println(pair2.getFirst());
        System.out.println(pair2.getSecond());
        System.out.println("pair2 = " + pair2);

//        Map<String, String> map = new HashMap<>();
    }
}
