package QuizZip;

public class TV {
    String strProduct;
    int nMadeYear;
    int nInch;

    TV() {
    }

    TV(String strProduct, int nMadeYear, int nInch) {
        this.strProduct = strProduct;
        this.nMadeYear = nMadeYear;
        this.nInch = nInch;
    }

    void show() {
        System.out.println(strProduct + "에서 만든 " + nMadeYear + "년형 "
                + nInch + "인치 TV");
    }
}
