package afternoon.project.level1;

import java.util.*;

// 역할을 담당하는 Driver 클래스
public class Driver {
    private Car car;
    private static final int K5_CAR = 1;
    private static final int GRAND = 2;
    private static final int G70 = 3;

    Scanner scanner = new Scanner(System.in);

    public void setCar(Car car) {
        this.car = car;
    }

    public void selectCar() {
        System.out.print("운전하고 싶은 차를 선택하세요. (1. K5 / 2. 그랜져 / 3. G70) : ");
        int option = scanner.nextInt();

        // findCar(int option)
        if (option == K5_CAR) {
            this.setCar(new K5Car());
        } else if (option == GRAND) {
            this.setCar(new Grand());
        } else if (option == G70) {
            this.setCar(new G70());
        }

        drive();
    }

    public void drive() {
        car.drive();
    }
}
