package sync;

public interface BankAccount {
    boolean withdraw(int account);      // 출금
    int getBalance();                   // 조정
}
