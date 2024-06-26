package cond;

// 이 코드에서는 각각 독립된 if 문이 있다. 따라서 해당하는 모든 할인을 적용
public class If5 {

    public static void main(String[] args) {
        int price = 10000; // 아이템 가격
        int age = 10; // 나이
        int discount = 0; // 할인

        // 한 사용자가 동시에 여러 할인을 받을 수 있음
        if (price >= 10000) {
//            discount = discount + 1000;
            discount += 1000;
            System.out.println("10000원 이상 구매, 1000원 할인");
        }

        if (age <= 10) {
//            discount = discount + 1000;
            discount += 1000;
            System.out.println("어린이 1000원 할인");
        }

        System.out.println("총 할인 금액 : " + discount + "원");
    }
}
