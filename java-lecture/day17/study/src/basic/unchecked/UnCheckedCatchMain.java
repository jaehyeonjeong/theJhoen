package basic.unchecked;

public class UnCheckedCatchMain {
    public static void main(String[] args) {
        Service service = new Service();
        service.callCatch();
//        service.catchThrow();
        System.out.println("정상종료");
    }
    // 예외처리를 필수로 하느냐 마느냐의 차이
}
