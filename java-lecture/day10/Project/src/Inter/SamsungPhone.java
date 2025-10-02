package Inter;

public class SamsungPhone implements MobilePhoneInterface {

    @Override
    public void sendCall() {
        System.out.println("링딩동");
    }

    @Override
    public void receiveCall() {
        System.out.println("전화왔습니다.");
    }

    public void finish() {
        System.out.println("전화를 종료하겠습니다.");
    }

    public static void main(String[] args) {
        SamsungPhone samsungPhone = new SamsungPhone();
        samsungPhone.sendCall();
        samsungPhone.receiveCall();
        samsungPhone.showLogo();
        samsungPhone.finish();
    }
}
