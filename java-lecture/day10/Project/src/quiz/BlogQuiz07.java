package quiz;

public class BlogQuiz07 {
    public static void main(String[] args) {
        Point3D point3D = new Point3D(10, 20, 3);
        System.out.println(point3D.toString());
        point3D.moveUp();
        System.out.println(point3D.toString());
        point3D.moveDown();
        System.out.println(point3D.toString());
        point3D.move(11, 22, 33);
        System.out.println(point3D.toString());
        point3D.move(12, 24);
    }
}
