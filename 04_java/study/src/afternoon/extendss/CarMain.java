package afternoon.extendss;

public class CarMain {
    public static void main(String[] args) {
        GasCar gasCar = new GasCar();
        ElectricCar electricCar = new ElectricCar(); // new ElectricCar() 쓰고 ctrl + alt + v
        HydrogenCar hydrogenCar = new HydrogenCar();

        gasCar.fillUp();
        gasCar.move();
        gasCar.openDoor();

        System.out.println();

        electricCar.charge();
        electricCar.move();
        electricCar.openDoor();

        System.out.println();

        hydrogenCar.fillHydrogen();
        hydrogenCar.move();
        hydrogenCar.openDoor();
    }
}
