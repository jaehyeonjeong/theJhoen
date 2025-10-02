import java.text.DecimalFormat;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static int LineNumber = 50;

    public static void main(String[] args) {

        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        Circle pizza = new Circle(); //pizza : 스택, new : 힙
        // new : Heap 메모리에 올라옴
        pizza.radius = 24;
        // Stack area에 올라간다.
        pizza.name = "포테이토 피자";
        System.out.println(decimalFormat.format(pizza.getArea()));
        pizza.getinfo();

        Line();

        Circle donut = new Circle();
        donut.name = "던킨 도넛";
        System.out.println(decimalFormat.format(donut.getArea()));
        donut.getinfo();

        Line();

        Rect rect = new Rect();
        rect.width = 3;
        rect.height = 6;
        rect.name = "직사각형";
        System.out.println(rect.name + "의 면적 : " + rect.getArea());
        rect.getInfo();

        Line();

        Rect rect01 = new Rect();
        rect01.width = 6;
        rect01.height = 6;
        rect01.name = "정사각형";
        System.out.println(rect01.name + "의 면적 : " + rect01.getArea());
        rect01.getInfo();
    }

    public static void Line(){
        for(int i = 0; i < LineNumber; i++){
            System.out.print("=");
        }
        System.out.println();
    }
}