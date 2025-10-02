package review02.car01;

public class Driver {
    private K5 ks;
    private Sonata sonata;

    public void setKs(K5 ks) {
        this.ks = ks;
    }

    public void setSonata(Sonata sonata) {

    }

    public void drive() {
        System.out.println("운전 시작");
        ks.startEngine();
        ks.speedUp();
        ks.offEngine();
    }
}
