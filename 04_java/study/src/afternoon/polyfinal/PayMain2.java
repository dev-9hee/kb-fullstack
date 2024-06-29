package afternoon.polyfinal;

import java.util.Scanner;

public class PayMain2 {
    public static void main(String[] args) {
        PaySystem2 paySystem2 = new PaySystem2(); // 역할 담당

        paySystem2.selectPay();
        paySystem2.selectAmount();
    }
}
