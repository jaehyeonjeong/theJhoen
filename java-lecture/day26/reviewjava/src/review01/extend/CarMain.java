package review01.extend;

public class CarMain {

    public static void main(String[] args) {
        ElectricCar electricCar = new ElectricCar();
        electricCar.move();
        electricCar.open();

        Car gasCar = new GasCar();
        gasCar.move();
        gasCar.open();          // 자식 클래스의 있는 메서드를 먼저 호출
        // charge 호출 안됨.

        Car car = new ElectricCar();
        // 부모 타입으로 바꿀때는 문제가 없으나
        // 자식 타입으로 바꿀때는 캐스팅이 필요하다.
        // 부모는 자식을 담을 수 있는데 자식은 부모를 담을 수 없다.
        // 업캐스팅(자식->부모), 다운캐스팅(부모->자식)
        //ElectricCar childCar = (ElectricCar) car;
//        childCar.open();
//        childCar.charge();

        // 오버로딩(파라미터가 다르면 같은이름의 메서드를 생성)
        // , 오버라이딩(상속된 메서드를 재사용)의 차이 구분 필요

        Car parentCar = new ElectricCar();      // 부모 클래스, 자식 클래스 둘다 가짐.
        ElectricCar childCar = (ElectricCar) parentCar;

        Car parentCar02 = new Car();            // 부모 클래스 만
        ElectricCar childCar02 = (ElectricCar) parentCar02;
        childCar02.charge();
        childCar02.open();
        childCar02.move();
        // 에러 터짐
        // 다형성을 형성하기 위해서는 선언은 자식 클래스로 사용

        // instanceof
        GasCar gasCar1 = parentCar02 instanceof Car ? ((GasCar) parentCar02) : null;

    }
}
