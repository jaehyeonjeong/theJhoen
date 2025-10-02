package BlogQuiz;

import java.util.Scanner;

public class Km2Mile extends Converter{

    public Km2Mile(double ratio){
        super.ratio = ratio;
    }

    @Override
    protected double convert(double srs) {
        return srs / super.ratio;
    }

    @Override
    protected String getSrcString() {
        return "Km";
    }

    @Override
    protected String getDestString() {
        return "mile";
    }

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println(getSrcString()+"을 "+getDestString()+"로 바꿉니다.");
        System.out.print(getSrcString()+"을 입력하세요>> ");
        double val = sc.nextDouble();
        double res = convert(val);
        System.out.println("변환 결과 : "+res+getDestString()+"입니다.");
        sc.close();
    }
}
