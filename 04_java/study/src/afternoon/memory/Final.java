package afternoon.memory;

public class Final {
    final int radius;
    static double PI = 3.14;

    public Final(int radius) {
        this.radius = radius;
    }

    public double getCircleArea() {
        return PI * this.radius * this.radius;
    }
}
