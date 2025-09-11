package QuizTest;

public class PhoneManager {
    public static void main(String[] args) {
        Phone phone = new Phone("정재현", "010-2464-2739");
        System.out.println(phone.getName() + " " + phone.getTel());

        // DTO : data transfer object (데이터 전달 객체)
//        PhoneRecord rPhone = new PhoneRecord("정재현", "010-2464-2739");
//        System.out.println(rPhone.name());
//        System.out.println(rPhone.tel());


    }
}
