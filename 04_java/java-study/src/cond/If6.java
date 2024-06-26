package cond;

// 만약 else if 를 쓰면, 첫 번째로 충족하는 조건만 할인이 적용되고 나머지는 무시된다. 따라서 사용자는 나머지 할인을 놓칠 수 있음
public class If6 {

    public static void main(String[] args) {
        int price = 10000; // 아이템 가격
        int age = 10; // 나이
        int discount = 0; // 할인

        // 사용자는 나머지 할인을 놓치게 됨
        if (price >= 10000) { // 이것만 수행 됨
//            discount = discount + 1000;
            discount += 1000;
            System.out.println("10000원 이상 구매, 1000원 할인");
        } else if (age <= 10) {
//            discount = discount + 1000;
            discount += 1000;
            System.out.println("어린이 1000원 할인");
        } else {
            System.out.println("할인 없음");
        }

        System.out.println("총 할인 금액 : " + discount + "원");
    }
}
