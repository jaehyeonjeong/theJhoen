public class ColorPointMain {
    public static void main(String[] args) {
        Point point = new Point(2, 5);
        point.set(10, 20);
        point.showPoint();

        ColorPoint colorPoint = new ColorPoint();
        colorPoint.set(30, 40);
        colorPoint.setColor("red");
        colorPoint.showPoint();
        colorPoint.showColorPoint();

        ColorPoint colorPoint1 = new ColorPoint(50, 60, "red");
        colorPoint1.showColorPoint();
    }
}
