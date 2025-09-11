package Test;

public class Mutable {
    private String owner;
    private double balance;

    public Mutable(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }

    // 잔액 조회
    public double getBalance() {
        return balance;
    }

    // 입금
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // 출금
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    // 소유자 변경(가변성 예시)
    public void changeOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return owner + "님의 계좌 잔액: " + balance + "원";
    }
}
