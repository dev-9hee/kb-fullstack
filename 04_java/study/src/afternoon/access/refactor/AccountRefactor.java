package afternoon.access.refactor;

public class AccountRefactor {
    public String bank; // public, 은행명
    String grade; // default, 회원등급
    private String name; // private, 계좌 소유주
    private int balance; // private, 은행 잔고

    public AccountRefactor(String bank, String grade, String name, int balance) {
        this.bank = bank;
        this.grade = grade;
        this.name = name;
        this.balance = balance;
    }
}
