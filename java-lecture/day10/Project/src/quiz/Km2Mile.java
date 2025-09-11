package quiz;

import java.util.Scanner;

public class Km2Mile extends Converter {
    public Km2Mile(double ratio) {
        this.ratio = ratio;
//        super.ratio = src; // super.ratio로 써도 된다.
    }

    @Override
    protected double convert(double srs) {
        return srs / super.ratio;
    }

    @Override
    protected String getSrcString() {
        return "KM";
    }

    @Override
    protected String getDestString() {
        return "Mile";
    }

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println(getSrcString() + "을 " + getDestString() + "로 바꿉니다.");
        System.out.println("KM? >> ");
        double val = sc.nextDouble();
        double res = convert(val);
        System.out.println("변환 결과 : " + res + getDestString() + "입니다.");
        sc.close();
    }
}
