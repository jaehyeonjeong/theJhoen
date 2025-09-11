public class Circle {
    int radius;

    void setRadius(int _r) {
        radius = _r;
    }

    double getArea() {
        return Math.PI * radius * radius;
    }

    // 생성자가 없으면 기본 생성자를 자동으로 만들어 준다.
    public Circle() {
        radius = 10;
    }

    // 생성자를 추가하면 CircleTest에서 호출할 수 있는 생성자는 반드시 파라미터를 넣어야한다.
    // Circle 기본 생성자를 따로 만들어주면 Circle() 기본형으로 Heap(new 객체) 저장이 가능하다.
    public Circle(int radius) {
        this.radius = radius; // this가 클래스 variable을 가리킴
    }

    void getInfo() {
        System.out.println("원의 반지름 : " + this.radius + ", 원의 넓이 : " + getArea());
    }
}
