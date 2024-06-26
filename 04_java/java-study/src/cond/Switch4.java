package cond;

// 자바 14 새로운 switch 문...
public class Switch4 {

    public static void main(String[] args) {
        int grade = 2;

        int coupon = switch(grade) { // 결과값이 변수에 대입됨!, 선택된 데이터를 반환
            case 1 -> 1000;
            case 2 -> 2000;
            case 3 -> 3000;
            default -> 500;
        };

        System.out.println("발급 받은 쿠폰 : " + coupon);
    }
}
