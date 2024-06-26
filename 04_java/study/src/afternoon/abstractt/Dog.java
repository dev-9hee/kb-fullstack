package afternoon.abstractt;

public class Dog extends AbstractAnimal {
    @Override
    public void sound() {
        System.out.println("강아지는 멍멍!!");
    }

    @Override
    public void eat() {
        System.out.println("강아지가 사료를 먹어요!");
    }
}
