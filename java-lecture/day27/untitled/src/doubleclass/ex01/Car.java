package doubleclass.ex01;

public class Car {
    private String model;
    private int chargeLevel;
    private Engine engine;

    public Car(String model, int chargeLevel) {
        this.model = model;
        this.chargeLevel = chargeLevel;
        // 클래스 자기 자신을 넣을 수 있는 this 키워드로 생성자 안에 넣을 수 있다.
        engine = new Engine();  // 생성
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

    // 완전 종속 관계에서는 내부 중첩 클래스를 사용하는 방안이 좋음
    private class Engine {
        public void start() {
            System.out.println("충전 레벨 확인 : " + chargeLevel);
            System.out.println(model + "의 엔진을 구동합니다.");
        }
    }
}
