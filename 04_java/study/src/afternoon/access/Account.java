package afternoon.access;

public class Account {
    int balance;

    Account(int balance) { // 시작 금액을 입력해서 생성하는 생성자
        this.balance = balance;
    }

    void deposit(int amount) { // 입금 기능
        this.balance += amount;
    }

    void withdraw(int amount) { // 인출 기능
        this.balance -= amount;
    }
}
