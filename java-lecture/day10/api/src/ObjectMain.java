public class ObjectMain {
    public static void main(String[] args) {
        Object point = new Point(10, 20);
        System.out.println(point.getClass().getName());
        System.out.println(point.hashCode());
        System.out.println(point.toString());
        System.out.println(point);

        Point point01 = new Point(100, 100);
        Point point02 = new Point(100, 100);
        Point point03 = new Point(200, 200);

        if(point01.equals(point02)) {
            System.out.println("point01과 point02는 같습니다.");
        }else {
            System.out.println("다릅니다.");
        }
    }
}
