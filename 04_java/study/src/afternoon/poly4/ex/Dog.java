package afternoon.poly4.ex;

public class Dog implements Animal{
    @Override
    public void sound() {
        System.out.println("강아지 멍멍!");
    }

    @Override
    public void eat() {
        System.out.println("강아지가 사료를 냠냠!");
    }
}
