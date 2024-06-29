package afternoon.poly4.ex;

public class Duck implements Animal, Fly{
    @Override
    public void sound() {
        System.out.println("오리 꽥꽥!");
    }

    @Override
    public void eat() {
        System.out.println("오리가 사료를 냠냠!");
    }

    @Override
    public void fly() {
        System.out.println("오리 날다~~!!!");
    }
}
