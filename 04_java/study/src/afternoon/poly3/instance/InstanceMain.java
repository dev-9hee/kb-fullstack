package afternoon.poly3.instance;

public class InstanceMain {
    public static void main(String[] args) {
        Parent parent = new Parent();
        Child child = new Child();
        GrandChild grandChild = new GrandChild();

        // instance of 의 왼쪽이 오른쪽으로 들어 갈 수 있는가!!
        System.out.println(parent instanceof Parent); // true
        System.out.println(child instanceof Parent); // true
        System.out.println(grandChild instanceof Parent); // true

        System.out.println();

        System.out.println(parent instanceof Child); // false
        System.out.println(child instanceof Child); // 인스턴스화된 인스턴스, 타입
        System.out.println(grandChild instanceof GrandChild); // true

        System.out.println();

        System.out.println(parent instanceof GrandChild); // false
        System.out.println(child instanceof GrandChild); // false
        System.out.println(grandChild instanceof GrandChild); // true
    }
}
