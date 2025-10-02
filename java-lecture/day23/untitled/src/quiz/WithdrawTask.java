package quiz;

public class WithdrawTask implements Runnable{
    private final Account acc;

    public WithdrawTask(Account acc) {
        this.acc = acc;
    }

    @Override
    public void run() {
        while(acc.getBalance() > 0){
            int amount = (int) (Math.random() * 4 + 1) * 500;
            acc.withdraw(amount);
        }
    }
}
