public class MethodOverloadingTest {
    public static void main(String[] args) {
        MethodOverloading methodOverloading = new MethodOverloading(); // new는 Heap메모리
        int result01 = methodOverloading.getSum(10, 10);
        int result02 = methodOverloading.getSum(10, 10, 10);
        double result03 = methodOverloading.getSum(10.0, 10);

        // 가비지 컬렉션 : GC => Heap 메모리 자동으로 수거
        // GC가 알아서 객체를 소멸시켜준다.
        // 메모리가 부하하는데 레퍼런스가 사라지면 수거대상이 된다.

        Book book01 = new Book("홍길동전", "허균"); // 홍길동전만 살고
        Book book02 = new Book("전우치전"); // 전우치전은 죽는다. (가비지 컬렉터의 수거 대상)
        book02 = book01;
        System.gc();    // 가비지 컬렉터 수거 요청을 보냄
        // 가비지 컬렉터의 수거대상은 프로그래머가 건드릴 수 없다.

        String a = new String("aaa");
        String b = new String("bbb");
        String c = new String("ccc");
        String d, e;
        a = null;       // 가비지 컬렉터 수거 대상
        d = c;          // d가 c를 가리키고 있기 때문에 수거 대상이 안됨
        c = null;       // d 변수가 참조대상이기 때문에 수거대상이 안됨
        // 즉 참조가 하나라도 걸려있으면 GC의 대상이 아니고 a만 null이기 때문에 GC의 수거대상이 된다.
        // main함수가 돌고나면 new를 할당한 객체들은 전부 GC의 수거 대상이 된다.
    }
}
