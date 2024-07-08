package scanner.ex;

import java.util.Scanner;

// 문제 - 음식점 주문
// 사용자로부터 음식의 이름( foodName ), 가격( foodPrice ), 그리고 수량( foodQuantity )을 입력받아, 주문한 음식의 총 가격을 계산하고 출력하는 프로그램을 작성하세요.
// 음식의 총 가격을 계산하세요. 총 가격은 각 음식의 가격( foodPrice )과 수량( foodQuantity )을 곱한 값이며, 이를 totalPrice 라는 이름의 변수에 저장하세요.
// 주문 정보와 총 가격을 출력하세요. 출력 형태는 "[음식 이름] [수량]개를 주문하셨습니다. 총 가격은 [총 가격]원 입니다." 이어야 합니다.
// 실행 결과 예시 ```
// 음식 이름을 입력해주세요: 피자
// 음식의 가격을 입력해주세요: 20000
// 음식의 수량을 입력해주세요: 2
// 피자 2개를 주문하셨습니다. 총 가격은 40000원입니다.
public class ScannerEx3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // 입력 받을 거야

        System.out.print("음식 이름을 입력해주세요 : ");
        String foodName = scanner.nextLine();

        System.out.print("음식의 가격을 입력해주세요 : ");
        int foodPrice = scanner.nextInt();

        System.out.print("음식 수량을 입력해주세요 : ");
        int foodQuantity = scanner.nextInt();

        int totalPrice = foodPrice * foodQuantity; // 총 가격

        System.out.println(foodName + " " + foodQuantity + "개를 주문하셨습니다. 총 가격은 " + totalPrice + "원입니다.");

    }
}
