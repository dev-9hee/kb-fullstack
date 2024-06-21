package afternoon.access.refactor;

public class AccountRefactorMain {
    public static void main(String[] args) {
        AccountRefactor account = new AccountRefactor("국민은행", "골드", "정지희", 1000000000);

        // public 요소 접근
        System.out.println("public 요소 접근");
        System.out.println("은행명은? " + account.bank);
        System.out.println();

        // default 요소 접근
        System.out.println("default 요소 접근");
        System.out.println("회원 등급은? " + account.grade);

        // private 요소 접근
//        System.out.println(account.name); // 오류
    }
}
