package afternoon.ref;

public class CustomerMain2 {
    public static void main(String[] args) {
        Customer customer1 = new Customer();
        Customer customer2 = new Customer();

        customer2 = customer1; // 주소값이 대입 됨
    }
}
