package sync;

// 출금 스레드 구현
public class WithdrawTask implements Runnable {
    // 어짜피 인터페이스라서  다음에 만드는 구현부에도 적용 가능
    private BankAccount account;
    private int amount;             // 할당량

    public WithdrawTask(BankAccount account, int amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        account.withdraw(amount);   // 남은 금액에서 출금 동작
    }
}
