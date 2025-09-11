public class Circle { // 스태틱

    // 매서드(Static) Area에 올라가는 곳
    int radius = 10;
    String name;

    double getArea() {
        return Math.PI * radius * radius;
    }

    void getinfo() {
        System.out.println("나의 이름은 " + name + "이고, 반지름은 " + radius + "입니다.");
    }
}
