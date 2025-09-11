package Test;

public class MutableMain {
    public static void main(String[] args) {
        Mutable mutable = new Mutable("정재현", 10000);
        mutable.deposit(5000); // 5000원 입금
        mutable.withdraw(3000); // 3000원 출금
        mutable.changeOwner("정다현");

        System.out.println(mutable); // 정다현님의 계좌 잔액 : 12000.0원
    }
}
