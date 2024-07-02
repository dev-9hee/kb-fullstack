package afternoon.lang.immutable.ex;

public class ImmutableDateMain {
    public static void main(String[] args) {
        ImmutableDate date1 = new ImmutableDate(2024, 7, 1);
        ImmutableDate date2 = date1;

        System.out.println("date2 의 년도만 2025 로 변경");
        date2 = date2.setYear(2025);

        System.out.println("date1 = " + date1);
        System.out.println("date2 = " + date2);
    }
}
