public class Rect {
    int width;
    int height;
    String name;

    int getArea() {
        return width * height;
    }

    void getInfo() {
        System.out.println("나의 타입은 사각형 : " + name + "이고, width와 height의 길이는 각각\n "
                + width + ", " + height + "이야");
    }


}
