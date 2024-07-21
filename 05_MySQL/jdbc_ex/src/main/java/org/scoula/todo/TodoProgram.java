package org.scoula.todo;

import java.util.Scanner;

public class TodoProgram {
    public static void main(String[] args) {
        // todo_user DB의 작업을 처리하기 위해 UserDaoImpl 클래스를 인스턴스화
        UserDaoImpl userDao = new UserDaoImpl();
        // 사용자 입력을 받기 위한 Scanner 클래스 인스턴스화
        Scanner scanner = new Scanner(System.in);

        // 로그인 한 사용자 정보를 저장하기 위해 UserVo 타입의 loggedInUser 생성
        // 지금은 로그인 전이므로 null 값 부여
        UserVo loggedInUser = null;

        // 로그인이 완료 되어서 loggedInUser 에 로그인한 사용자의 정보를 가지는 UserVo 객체 값이 들어갈 때 까지
        // 반복되는 while 문
        while (loggedInUser == null) {
            System.out.println("TodoList 프로그램에 오신 것을 환영합니다.");
            System.out.println("로그인을 해주십시오.");
            System.out.print("ID: ");
            String userId = scanner.nextLine();
            System.out.print("PASSWORD: ");
            String password = scanner.nextLine();

            // 위에서 입력 받은 id, password 를 userDao.loginUser 에 전달하여 로그인 작업을 진행
            // 로그인이 성공하면 todo_user 테이블로 부터 받은 사용자 정보를 리턴 하므로 해당 정보를 loggedInUser 부여
            // 로그인이 실패하면 null 이 리턴 되므로 해당 while 문은 계속 반복된다
            loggedInUser = userDao.loginUser(userId, password);
            if (loggedInUser == null) {
                System.out.println("로그인 정보가 잘못되었습니다. 다시 시도하십시오.");
            }
        }

        // 로그인이 성공하면 위의 while 문이 종료되고, TodoList 확인이 가능해야 하므로
        // todo2 DB의 작업을 처리하기 위해 TodoDaoImpl 클래스를 인스턴스화
        TodoDaoImpl todoDao = new TodoDaoImpl();

        // 로그인한 사용자가 작성한 총 Todo2 의 수를 보여주기 위해 todoDao.getTotalCount 를 수행
        // 로그인한 사용자 정보는 loggedInUser 에 저장되어 있으므로 loggedInUser.getUserId() Getter 를 사용하여
        // 로그인한 사용자의 UserId를 전달하여 확인
        int totalTodoCount = todoDao.getTotalCount(loggedInUser.getUserId());
        System.out.println(loggedInUser.getName() + " 님 반갑습니다!");
        System.out.println(loggedInUser.getName() + " 님의 총 Todo 개수 : " + totalTodoCount);

        while (true) {
            // 메뉴 목록 출력
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

            // 사용자의 입력에 따라 각각 원하는 기능을 수행해 준다
            if (choice == 1) { // 전체 목록 조회
                // 로그인한 사용자가 작성한 Todo2 전체 목록 조회는 TodoDaoImpl 의 getTodosByUserId 에 구현되어있으므로 해당 메서드 실행
                // user_id 는 loggedInUser 에 저장되어 있으므로 Getter 를 사용하여 로그인한 사용자의 id 를 전달
                todoDao.getTodosByUserId(loggedInUser.getUserId());
            } else if (choice == 2) { // 미완료 목록 조회
                // 로그인한 사용자가 작성한 Todo2 미완료 목록 조회는 TodoDaoImpl 의 getUncompletedTodosUserId 에 구현되어있으므로 해당 메서드 실행
                // user_id 는  loggedInUser 에 저장되어 있으므로 Getter 를 사용하여 로그인한 사용자의 id 를 전달
                todoDao.getUncompletedTodosUserId(loggedInUser.getUserId());
            } else if (choice == 3) { // 완료 목록 조회
                // 로그인한 사용자가 작성한 Todo2 완료 목록 조회는 TodoDaoImpl 의 getCompletedTodosByUserId 에 구현되어있으므로 해당 메서드 실행
                // user_id 는  loggedInUser 에 저장되어 있으므로 Getter 를 사용하여 로그인한 사용자의 id 를 전달
                todoDao.getCompletedTodosByUserId(loggedInUser.getUserId());
            } else if (choice == 4) { // 완료 처리
                // 완료 처리할 todo2 의 id 를 입력 받기
                System.out.print("완료 처리할 Todo 의 ID 숫자를 입력해 주세요 : ");
                int id = scanner.nextInt();
                scanner.nextLine();
                // makeTodoCompleted 메서드에 입력 받은 todo2 id 와 사용자의 user_id 를 전달하여 처리
                todoDao.makeTodoCompleted(id, loggedInUser.getUserId());
            } else if (choice == 5) { // 추가
                // 추가할 todo2 의 내용을 입력 받기
                System.out.print("추가할 Todo 의 내용을 입력해 주세요 : ");
                String todo = scanner.nextLine();
                // createTodo 메서드에 입력 받은 todo2 내용과 사용자의 user_id 를 전달하여 처리
                todoDao.createTodo(todo, loggedInUser.getUserId());
            } else if (choice == 6) { // 삭제
                // 삭제할 todo2 의 id 입력 받기
                System.out.print("삭제 처리할 Todo 의 ID 숫자를 입력해 주세요 : ");
                int id = scanner.nextInt();
                scanner.nextLine();
                // deleteTodo 메서드에 삭제 할 todo2 id 와 사용자의 user_id 를 전달하여 처리
                todoDao.deleteTodo(id, loggedInUser.getUserId());
            } else if (choice == 7) { // 전체 목록 + 작성자 확인
                // getAllTodosWithUserName 메서드를 실행하여 JOIN 된 테이블의 정보를 출력
                todoDao.getAllTodosWithUserName();
            } else if (choice == 8) { // 프로그램 종료
                return;
            } else {
                System.out.println("잘못된 선택입니다. 다시 시도하십시오.");
            }
        }
    }
}
