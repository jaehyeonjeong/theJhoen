package quiz;

import static utils.MyLogger.log;

public class BlogQuiz04 {
    public static void main(String[] args) throws InterruptedException {
        Account account = new Account(10000);
        Thread thread01 = new Thread(new WithdrawTask(account), "Thread-01");
        Thread thread02 = new Thread(new WithdrawTask(account), "Thread-02");

        thread01.start();
        thread02.start();
        thread01.join();
        thread02.join();

        log("최종 금액 : " + account.getBalance());
    }
}
