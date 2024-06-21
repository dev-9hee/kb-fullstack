package afternoon.access;

public class BankAccount {
    private int balance;

    public BankAccount() { // 생성되면 잔고는 0원으로 되게 설정
        this.balance = 0;
    }

    public void deposit(int amount) {
        if (isAmountValid(amount)) {
            this.balance += amount;
            System.out.println("현재 잔고는 : " + this.balance + " 입니다");
        } else {
            System.out.println("유효하지 않은 금액입니다.");
        }
    }

    // ctrl + alt + L : 줄 맞추기, 프리티어
    public void withDraw(int amount) {
        if (isAmountValid(amount)) {
            if (isPossibleWithdraw(amount)) {
                this.balance -= amount;
                System.out.println("현재 잔고는 : " + this.balance + " 입니다");
            } else {
                System.out.println("잔고가 부족합니다. 현재 잔고 : " + this.balance + " 입니다");
            }
        } else {
            System.out.println("유효하지 않은 금액입니다.");
        }
    }

    public void getBalance() { // 제어는 못 함, 값은 볼 수 있음
        System.out.println("현재 잔고는 : " + this.balance + " 입니다");
    }

    private boolean isAmountValid(int amount) { // 0원 이상 했는지 검사하는 메서드
        return amount > 0;
    }

    private boolean isPossibleWithdraw(int amount) { // 잔고가 amount 입력 값보다 크거나 같은지 검사하는 메서드
        return this.balance >= amount;
    }
}
