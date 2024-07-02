package afternoon.nested.inner.ex1;

public class Engine {
    private Car car;

    public Engine(Car car) {
        this.car = car;
    }

    public void start() {
        System.out.println("자동차 주유 상태 확인 : " + car.getOilAmount());
        if (car.getOilAmount() > 0) {
            System.out.println(car.getModel() + "의 엔진이 구동합니다.");
        }
    }
}
