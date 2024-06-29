package afternoon.polyfinal;

import java.util.Scanner;

public class PayMain {
    public static void main(String[] args) {
        PaySystem paySystem = new PaySystem(); // 역할 담당
        Scanner scanner = new Scanner(System.in);
        // 사용자 입력 및 입력을 저장할 변수 선언
        int option; // 1번 선택하면 kb, 2번 선택하면 카카오
        int amount; // 얼마

        // 사용자로부터 필요한 정보를 입력 받기
        System.out.print("결제 옵션을 입력하세요 (1. KB 페이 / 2. 카카오페이 / 3. 네이버페이) : ");
        option = scanner.nextInt();

        System.out.print("결제 금액을 입력하세요 : ");
        amount = scanner.nextInt();

        System.out.println();

        // 사용자 입력에 따라 pay 의 '구현' 설정
        if (option == 1) {
            KBPay kbPay = new KBPay();
            paySystem.setPay(kbPay);
        } else if (option == 2) {
            paySystem.setPay(new KakaoPay());
        } else if (option == 3) {
            paySystem.setPay(new NaverPay());
        }

        paySystem.payment(amount); // 결정 된 구현에서 결제 진행
    }
}
