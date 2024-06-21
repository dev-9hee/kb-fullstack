package afternoon.extendss.superrr;

public class Item {
    private String name;
    private int price;

    // 아이템의 이름과 가격을 정해줘야 하므로 생성자 설정
    Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public void print() {
        System.out.println("아이템의 이름은 : " + this.name);
        System.out.println("아이템의 가격은 : " + this.price);
    }
}
