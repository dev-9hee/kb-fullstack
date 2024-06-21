package afternoon.ref;

public class CustomerMain {
    public static void main(String[] args) {
        Customer customer1 = new Customer();
        customer1.name = "정지희";

        Customer customer2 = null; // 의도된 빈 값, 아무것도 가르키지 않는, 연결할 인스턴스가 없다!

        System.out.println(customer2.name); // NullPointerException 에러, 런타임 에러(주소값에 가봐야 안다)
//        customer2 = customer1;
//        System.out.println(customer2.name);
//        System.out.println(customer1.name);
    }
}
