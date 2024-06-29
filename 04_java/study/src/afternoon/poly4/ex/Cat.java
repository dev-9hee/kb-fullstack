package afternoon.poly4.ex;

public class Cat implements Animal {
    @Override
    public void sound() {
        System.out.println("고양이 야옹!");
    }

    @Override
    public void eat() {
        System.out.println("고양이가 츄르를 홀쨕!");
    }
}
