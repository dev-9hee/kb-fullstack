package afternoon.access.rafactor2;

import afternoon.access.refactor.AccountRefactor;

public class AccountRefactorOuterMain {
    public static void main(String[] args) {
        AccountRefactor account = new AccountRefactor("신한은행", "골드", "정지희", 10000000);

        // public 요소 접근
        System.out.println("public 요소 접근");
        System.out.println(account.bank);

        // default 요소 접근
//        System.out.println("default 요소 접근");
//        System.out.println("회원 등급은? " + account.grade); // default 접근 불가, 다른 패키지
    }
}
