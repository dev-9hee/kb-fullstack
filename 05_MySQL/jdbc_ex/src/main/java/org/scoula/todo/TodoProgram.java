package org.scoula.todo;

import java.util.Scanner;

public class TodoProgram {
    public static void main(String[] args) {
        UserDaoImpl userDao = new UserDaoImpl();
        Scanner scanner = new Scanner(System.in);

        UserVo loggedInUser = null;

        while (loggedInUser == null) {
            System.out.println("TodoList 프로그램에 오신 것을 환영합니다.");
            System.out.println("로그인을 해주십시오.");
            System.out.print("ID: ");
            String userId = scanner.nextLine();
            System.out.print("PASSWORD: ");
            String password = scanner.nextLine();

            loggedInUser = userDao.loginUser(userId, password);
            if (loggedInUser == null) {
                System.out.println("로그인 정보가 잘못되었습니다. 다시 시도하십시오.");
            }
        }

        TodoDaoImpl todoDao = new TodoDaoImpl();

        int totalTodoCount = todoDao.getTotalCount(loggedInUser.getUserId());
        System.out.println(loggedInUser.getName() + " 님 반갑습니다!");
        System.out.println(loggedInUser.getName() + " 님의 총 Todo 개수 : " + totalTodoCount);

        while (true) {
            System.out.println("====== TodoList 프로그램 ======");
            System.out.println("1. Todo 전체 목록 조회");
            System.out.println("2. Todo 미완료 목록 조회");
            System.out.println("3. Todo 완료 목록 조회");
            System.out.println("4. Todo 완료 처리");
            System.out.println("5. Todo 추가");
            System.out.println("6. Todo 삭제");
            System.out.println("7. Todo 전체 목록 + 작성자 확인");
            System.out.println("8. 프로그램 종료");
            System.out.print("원하는 작업 번호를 입력하세요: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) { // 전체 목록 조회
                todoDao.getTodosByUserId(loggedInUser.getUserId());
            } else if (choice == 2) { // 미완료 목록 조회
                todoDao.getUncompletedTodosUserId(loggedInUser.getUserId());
            } else if (choice == 3) { // 완료 목록 조회
                todoDao.getCompletedTodosByUserId(loggedInUser.getUserId());
            } else if (choice == 4) { // 완료 처리
                System.out.print("완료 처리할 Todo 의 ID 숫자를 입력해 주세요 : ");
                int id = scanner.nextInt();
                scanner.nextLine();
                todoDao.makeTodoCompleted(id, loggedInUser.getUserId());
            } else if (choice == 5) { // 추가
                System.out.print("추가할 Todo 의 내용을 입력해 주세요 : ");
                String todo = scanner.nextLine();
                todoDao.createTodo(todo, loggedInUser.getUserId());
            } else if (choice == 6) { // 삭제
                System.out.print("삭제 처리할 Todo 의 ID 숫자를 입력해 주세요 : ");
                int id = scanner.nextInt();
                scanner.nextLine();
                todoDao.deleteTodo(id, loggedInUser.getUserId());
            } else if (choice == 7) { // 전체 목록 + 작성자 확인
                todoDao.getAllTodosWithUserName();
            } else if (choice == 8) { // 프로그램 종료
                return;
            } else {
                System.out.println("잘못된 선택입니다. 다시 시도하십시오.");
            }
        }
    }
}
