package afternoon.pack.a;

public class Boss {
    String name;
    int age;

    public Boss(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void printBoss() {
        System.out.println("사장이 전달합니다");
        System.out.println("이름 : " + this.name);
        System.out.println("나이 : " + this.age );
    }
}
