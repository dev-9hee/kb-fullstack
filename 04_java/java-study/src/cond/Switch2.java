package cond;

public class Switch2 {

    public static void main(String[] args) {
        int grade = 2;

        int coupon;

        switch (grade) {
            case 1:
                coupon = 1000;
                break; // break 문은 현재 실행 중인 코드를 끝내고 switch 문을 빠져나가게 하는 역할
            case 2:
                coupon = 2000;
                break;
            case 3:
                coupon = 3000;
                break;
            default:
                coupon = 500;
        }
        System.out.println("발급 받은 쿠폰 : " + coupon);
    }
}
