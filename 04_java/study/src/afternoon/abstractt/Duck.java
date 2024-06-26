package afternoon.abstractt;

public class Duck extends AbstractAnimal{
    @Override
    public void sound() {
        System.out.println("오리는 꽥꽥!!");
    }

    @Override
    public void eat() {
        System.out.println("오리는 도토리를 먹어요!");
    }

    public void fly() {
        System.out.println("오리 날다~!!");
    }
}
