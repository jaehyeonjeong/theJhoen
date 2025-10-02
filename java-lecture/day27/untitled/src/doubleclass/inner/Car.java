package doubleclass.inner;

public class Car {
    private String model;
    private int chargeLevel;
    private Engine engine;

    public Car(String model, int chargeLevel) {
        this.model = model;
        this.chargeLevel = chargeLevel;
        // 클래스 자기 자신을 넣을 수 있는 this 키워드로 생성자 안에 넣을 수 있다.
        engine = new Engine(this);  // 생성
    }

    // model Charge getter
    public String getModel() {
        return model;
    }

    public int getChargeLevel() {
        return chargeLevel;
    }

    public void start() {
        engine.start();
        System.out.println(model + " 시작 완료");
    }
}
