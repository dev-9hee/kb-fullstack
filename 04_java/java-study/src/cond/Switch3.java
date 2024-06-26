package cond;

public class Switch3 {

    public static void main(String[] args) {
        int grade = 2;

        int coupon;

        // 값이 같은지 확인하는 연산만 가능하다. (문자도 가능)
        switch (grade) {
            case 1:
                coupon = 1000;
                break; // break 문은 현재 실행 중인 코드를 끝내고 switch 문을 빠져나가게 하는 역할
            // case 2 에는 break 문이 없다! 그러면 중단하지 않고 바로 다음에 있는 case 3 의 코드를 실행
            case 2:
            case 3:
                coupon = 3000;
                break;
            default:
                coupon = 500;
        }
        System.out.println("발급 받은 쿠폰 : " + coupon);
    }
}
