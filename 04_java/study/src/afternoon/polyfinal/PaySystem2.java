package afternoon.polyfinal;

import java.util.Scanner;

public class PaySystem2 {
    private Pay pay;
    private static final int KB_PAY = 1;
    private static final int KAKAO_PAY = 2;
    private static final int NAVER_PAY = 3;

    Scanner scan = new Scanner(System.in);

    public void setPay(Pay pay) { this.pay = pay; }

    public void selectPay() {
        System.out.print("결제 옵션을 입력하세요 (1. KB 페이 / 2. 카카오페이 / 3. 네이버페이) : ");
        int option = scan.nextInt();
        this.findPay(option);
    }

    public void findPay(int option) {
        if (option == KB_PAY) {
            this.setPay(new KBPay());
        } else if (option == KAKAO_PAY) {
            this.setPay(new KakaoPay());
        } else if (option == NAVER_PAY) {
            this.setPay(new NaverPay());
        }
    }

    public void selectAmount() {
        System.out.print("결제 금액을 입력하세요 : ");
        int amount = scan.nextInt();
        this.payment(amount);
    }

    public void payment(int amount) {
        System.out.println("결제를 시작합니다.");
        pay.pay(amount);
    }
}
