package org.scoula.user;

import java.util.Scanner;

public class ManageUserProgram {
    public static void main(String[] args) {
        loginAndChoice();
    }

    private static void loginAndChoice() {
        ManageUser manageUser = new ManageUser(); // db 통신 클래스 객체 생성
        Scanner scanner = new Scanner(System.in); // 입력 받을 거임

        User loggedInUser = null;

        while (loggedInUser == null) {
            System.out.println("회원 관리 프로그램에 오신 것을 환영합니다.");
            System.out.println("로그인을 해주세요!!");
            System.out.print("ID : ");
            String id = scanner.nextLine();
            System.out.print("PASSWORD : ");
            String password = scanner.nextLine();

            loggedInUser = manageUser.loginUser(id, password);
            if (loggedInUser == null) {
                System.out.println("로그인 정보가 잘못되었습니다. 다시 시도하세요!!");
                System.out.println("=================================================");
            }
        }

        System.out.println("===== 회원 관리 프로그램 =====");
        // 사용자의 입력을 받아서 회원 목록을 조회하고 회원 추가, 삭제를 하는 프로그램으로 구성
        while (true) {
            System.out.println("1. 회원 목록 조회");
            System.out.println("2. 회원 추가");
            System.out.println("3. 회원 삭제");
            System.out.println("4. 특정 이름을 가지는 회원 조회");
            System.out.println("5. 회원 정보 수정");
            System.out.println("6. 로그아웃");
            System.out.print("원하는 작업 번호를 입력하세요 : ");

            int choice = scanner.nextInt(); // 선택한 작업 번호 저장하는 정수형 변수
            scanner.nextLine();

            if (choice == 1) {
                manageUser.getAllUsers();
            } else if (choice == 2) { // 회원 추가
                System.out.print("추가할 회원의 ID : ");
                String newId = scanner.nextLine();
                System.out.print("이름 : ");
                String name = scanner.nextLine();
                System.out.print("비밀번호 : ");
                String newPassword = scanner.nextLine();
                System.out.print("나이 : ");
                int age = scanner.nextInt();
                scanner.nextLine();
                System.out.print("멤버쉽 여부 (true/false) : ");
                boolean membership = scanner.nextBoolean();
                scanner.nextLine();

                User newUser = new User(newId, name, newPassword, age, membership);
                manageUser.addUser(newUser);
            } else if (choice == 3) { // 회원 삭제
                System.out.print("삭제할 회원의 ID : ");
                int deleteId = scanner.nextInt();
                manageUser.deleteUserById(deleteId);
            } else if (choice == 4) {
                System.out.print("검색할 이름의 일부를 입력하세요 : ");
                String namePart = scanner.nextLine();
                manageUser.searchUsersByName(namePart);
            } else if (choice == 5) {
                System.out.print("수정할 회원의 ID를 입력하세요 : ");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.print("새 이름 : ");
                String updateName = scanner.nextLine();
                System.out.print("새 비밀번호 : ");
                String updatePassword = scanner.nextLine();
                System.out.print("새 나이 : ");
                int updateAge = scanner.nextInt();
                scanner.nextLine();
                System.out.print("새 멤버쉽 여부 (true/false) : ");
                boolean updateMembership = scanner.nextBoolean();
                scanner.nextLine();

                manageUser.updateUserDetails(id, updateName, updatePassword, updateAge, updateMembership);
            } else if (choice == 6) {
                manageUser.logoutUser();

            } else {
                System.out.println("잘못된 선택입니다. 다시 시도하세요!!");
            }
        }
    }
}
