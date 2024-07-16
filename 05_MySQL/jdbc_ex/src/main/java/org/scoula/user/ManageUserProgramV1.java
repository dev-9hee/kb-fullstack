package org.scoula.user;

import java.util.Scanner;

public class ManageUserProgramV1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        // 회원 정보 입력 받기
//        System.out.print("추가할 회원의 ID : ");
//        String id = scanner.nextLine();
//        System.out.print("이름 : ");
//        String name = scanner.nextLine();
//        System.out.print("비밀번호 : ");
//        String password = scanner.nextLine();
//        System.out.print("나이 : ");
//        int age = scanner.nextInt();
//        scanner.nextLine();
//        System.out.print("멤버쉽 여부 (true/false) : ");
//        boolean membership = scanner.nextBoolean();
//        scanner.nextLine();
//
//        // 입력 받은 정보로 생성자를 통해 새로운 회원 객체 생성
//        User newUser = new User(id, name, password, age, membership);
//
//        // 데이터베이스 접속
//        Connection conn = JDBCUtil.getConnection();
//
//        ManageUser manageUser = new ManageUser();
//        manageUser.addUser(newUser);

//        // 삭제할 회원의 id 입력 받기
//        System.out.print("삭제할 회원의 ID : ");
//        int deleteId = scanner.nextInt();
//        scanner.nextLine();
//
//        // 삭제 기능을 실행, 기능을 구현한 deleteUserById를 사용하여 회원 삭제 진행
//        ManageUser manageUser = new ManageUser();
//        manageUser.deleteUserById(deleteId);

        // 회원 목록 출력
        ManageUser manageUser = new ManageUser();
        manageUser.getAllUsers();
    }
}