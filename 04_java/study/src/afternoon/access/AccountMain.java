package afternoon.access;

public class AccountMain {
    public static void main(String[] args) { // Shift + enter : 어디 있든 다음칸으로
        Account account = new Account(10000);

        account.deposit(10000); // 이자
        account.withdraw(5000); // 학식

        System.out.println("계좌에 남은 금액은 : " + account.balance);
    }
}
