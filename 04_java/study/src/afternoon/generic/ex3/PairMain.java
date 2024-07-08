package afternoon.generic.ex3;

public class PairMain {
    public static void main(String[] args) {
        Pair<String, String> nameData = new Pair<>("정지희", "name");
        Pair<Integer, String> ageData = new Pair<>(25, "age");
        Pair<Boolean, String> marriedData = new Pair<>(false, "married");

        // toString 으로 인스턴스 출력
        System.out.println(nameData);
        System.out.println(ageData);
        System.out.println(marriedData);
    }
}
