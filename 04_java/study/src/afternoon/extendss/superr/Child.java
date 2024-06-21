package afternoon.extendss.superr;

public class Child extends Parent {
    public String name = "자식 클래스";

    @Override
    public void hello() {
        System.out.println("자식 클래스 : 안녕하세요!");
    }

    public void superCall() {
        System.out.println("자신의 이름을 가져와 봅시다 : " + this.name);
        System.out.println("부모의 이름을 가져와 봅시다 : " + super.name);

        this.hello();
        super.hello();
    }
}
