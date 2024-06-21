package afternoon.access;

public class BankAccountMain {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        account.deposit(100);
        account.deposit(100);
        account.getBalance();
        account.deposit(-100);
        account.withDraw(100);
        account.withDraw(-30);
        account.withDraw(1000);
        account.getBalance();
    }
}
