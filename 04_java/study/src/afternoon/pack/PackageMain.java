package afternoon.pack;

import afternoon.pack.nouveau.Customer;
import afternoon.pack.a.Boss;

public class PackageMain {
    public static void main(String[] args) {
//        Customer customer1 = new Customer();
//        afternoon.pack.nouveau.Customer customer2 = new afternoon.pack.nouveau.Customer();

        Boss boss = new Boss("정지희", 25);
        boss.printBoss(); // 클래스 내부의 정보 출력
    }
}
