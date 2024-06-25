package afternoon.poly3.overriding;

public class OverridingMain {
    public static void main(String[] args) {
//        Parent parent = new Parent();
//        System.out.println("parent value = " + parent.value);
//        parent.method();
//
//        Child child = new Child();
//        System.out.println("child value = " + child.value);
//        child.method();

        Parent poly = new Child();
        System.out.println("poly value = " + poly.value); // poly value = parent
        // 메서드가 오버라이딩 되어 있는 경우 오버라이딩 된 메서드가 항상 우선권을 가짐..!
        // 더 하위 자손이 있다면 제일 마지막에 오버라이딩 된 메서드가 우선권을 가짐
        poly.method(); // Child method
    }
}
