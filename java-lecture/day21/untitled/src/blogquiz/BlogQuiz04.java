package blogquiz;

import static utils.MyLogger.logSave;
import static utils.ThreadUtil.sleep;

public class BlogQuiz04 {
    public static void main(String[] args) throws InterruptedException {
        Runnable r = new RunnableEx12();
        new Thread(r).start();
        new Thread(r).start();
    }

    static class Account {
        private int balance = 1000;

        public int getBalance() {
            return balance;
        }

        public void withdraw(int money) {
            balance -= money;
            if(balance < 0) {
                balance += money;
            }
        }
    }


    static class RunnableEx12 implements Runnable {
        Account acc = new Account();

        public void run() {
            while (acc.getBalance() > 0) {
                // 100, 200, 300중의 한 값을 임으로 선택해서 출금(withdraw)
                int money = (int) (Math.random() * 3 + 1) * 100;
                acc.withdraw(money);
//                System.out.println("balance:" + acc.getBalance());
                logSave("balance:" + acc.getBalance());
            }
        } // run()
    }
}
