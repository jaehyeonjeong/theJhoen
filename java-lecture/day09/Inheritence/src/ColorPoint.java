public class ColorPoint extends Point{
    //private int x, y;
    private String color;

    public ColorPoint() {
       super(0, 0);
    }

    public ColorPoint(int x, int y, String color) {
        super(x, y);    // 부모 클래스의 기본생성자가 없으므로 super는 무조건 참조
        this.color = color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void showColorPoint() {
        System.out.print(color + " / ");
        showPoint(); // public 으로 열려있는 부모 매서드
//        System.out.println("""
//                (%d + %d)""".formatted(x, y));
    }
}
