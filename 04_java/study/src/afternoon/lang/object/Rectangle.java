package afternoon.lang.object;

public class Rectangle {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        // this 객체와 o 객체가 같은 객체를 가리키고 있다면 (주소값이 같다면) 두 객체는 동등하므로 true 를 반환
        if (this == o) return true;
        // 만약 o가 null 이거나 this 객체의 클래스와 o 객체의 클래스가 다르다면 두 객체는 동등하지 않으므로 false 를 반환
        if (o == null || getClass() != o.getClass()) return false;
        // o 객체를 Rectangle 타입으로 다운 캐스팅
        Rectangle rectangle = (Rectangle) o;
        // 만약 두 필드가 모두 같다면 두 객체는 동등하므로 true 를 반환하고, 그렇지 않다면 false 를 반환
        return width == rectangle.width && height == rectangle.height;
    }
}
