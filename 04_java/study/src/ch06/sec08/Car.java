package ch06.sec08;

public class Car {
    // 필드 선언
    int gas;
    String model;
    boolean full;

    public Car(boolean full) {
        this.full = full;
    }

    public int getGas() {
        return gas;
    }

    public void setGas(int gas) {
        this.gas = gas;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
