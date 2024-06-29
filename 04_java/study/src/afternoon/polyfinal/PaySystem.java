package afternoon.polyfinal;

public class PaySystem {
    private Pay pay;

    public void setPay(Pay pay) {
        this.pay = pay;
    }

    public void payment(int amount) {
        System.out.println("결제를 시작합니다.");
        pay.pay(amount);
    }
}
