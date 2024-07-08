package scanner.ex;

// 문제 - 이름과 나이 반복
// 사용자로부터 이름과 나이를 반복해서 입력받고, 입력받은 이름과 나이를 출력하는 프로그램을 작성하세요. 사용자가 "종료"를 입력하면 프로그램이 종료되어야 합니다.
// 실행 결과 예시 ```
// 이름을 입력하세요 (종료를 입력하면 종료): 자바
// 나이를 입력하세요: 30
// 입력한 이름: 자바, 나이: 30
// 이름을 입력하세요 (종료를 입력하면 종료): 하니
// 나이를 입력하세요: 20
// 입력한 이름: 하니, 나이: 20
// 이름을 입력하세요 (종료를 입력하면 종료): 종료
// 프로그램을 종료합니다.

import java.util.Scanner;

public class ScannerWhileEx1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) { // 무한반복
            System.out.print("이름을 입력하세요 (종료를 입력하면 종료) : ");
            String name = scanner.nextLine(); // nextLine() 은 라인까지를 문자로 읽어오는거!, \n(읽어서 넘어감)

            if (name.equals("종료")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            System.out.print("나이를 입력하세요 : ");
            int age = scanner.nextInt(); // nextInt() : 숫자만 읽어옴, ex> 10\n(enter) => 10만 읽어오고 \n 남아있음
            scanner.nextLine(); // 매우 중요..., 숫자 입력 후의 줄바꿈 처리, 라인을 읽어주고 버림

            System.out.println("입력한 이름: " + name + ", 나이: " + age);
        }
    }
}
