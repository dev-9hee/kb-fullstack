package afternoon.extendss.superrr;

public class Album extends Item{
    private String artist;

    Album(String name, int price, String artist) {
        super(name, price);
        this.artist = artist;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("앨범의 아티스트는 : " + this.artist);
    }
}
