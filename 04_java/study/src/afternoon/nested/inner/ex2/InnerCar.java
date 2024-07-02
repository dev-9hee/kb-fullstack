package afternoon.nested.inner.ex2;

public class InnerCar {
    private String model;
    private int oilAmount;
    private Engine engine;

    public InnerCar(String model, int oilAmount) {
        this.model = model;
        this.oilAmount = oilAmount;
        this.engine = new Engine();
    }

    public String getModel() {
        return model;
    }

    public int getOilAmount() {
        return oilAmount;
    }

    public void start() {
        engine.start();
        System.out.println(model + "의 주행을 시작합니다!");
    }

    private class Engine {
        public void start() {
            System.out.println("자동차 주유 상태 확인 : " + oilAmount);
            if (oilAmount > 0) {
                System.out.println(model + "의 엔진이 구동합니다.");
            }
        }
    }
}
