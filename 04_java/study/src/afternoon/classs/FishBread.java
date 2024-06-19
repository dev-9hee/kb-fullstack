package afternoon.classs;

import java.util.Date;

public class FishBread {
    String taste = "팥"; // 붕어빵의 맛 정보를 담당 (팓/슈크림/etc)
    String shape = "붕어"; // 붕어빵의 모양 담당 (붕어/잉어/etc)
    int price = 500; // 붕어빵의 가격 담당
    Date makeTime = new Date(); // 붕어빵이 만들어진 시간 설정

    FishBread() {} // 아무런 매개변수를 받지 않는 생성자를 선언

    FishBread(String taste, String shape, int price) {
        this.taste = taste;
        this.shape = shape;
        this.price = price;
    }

    void printFishBread() { // void : return 타입이 없음
        System.out.println("붕어빵의 맛은!? : " + this.taste);
        System.out.println("붕어빵의 모양은!? : " + this.shape);
        System.out.println("붕어빵의 가격은!? : " + this.price);
        System.out.println("붕어빵이 만들어진 시간은!? : " + this.makeTime);
    }
}
