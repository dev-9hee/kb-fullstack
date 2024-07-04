package beforenoon.ch12.sec07;

import java.util.Arrays;
import java.util.Random;

public class RandomExample {
    public static void main(String[] args) {
        // 선택번호
        int[] selectNumber = new int[6];
        //  seed 값으로 3을 사용하여 Random 객체를 생성, 이렇게 하면 항상 같은 순서의 난수가 생성
        Random random = new Random(3);
        System.out.println("선택번호: ");
        // random.nextInt(45) + 1을 통해 1부터 45 사이의 랜덤 정수를 생성
        // 1부터 45 사이의 숫자 6개를 랜덤으로 선택하여 출력하는 기능을 수행
        // 이때 seed 값으로 3을 사용하였기 때문에, 매번 동일한 순서의 난수가 생성될 것
        for (int i=0; i<6; i++) {
            selectNumber[i] = random.nextInt(45) + 1;
            System.out.print(selectNumber[i] + " ");
        }
        System.out.println("\n");

        // 당첨번호
        int[] winningNumber = new int[6];
        random = new Random(5); // 같은 seed 값을 사용하면 항상 동일한 순서의 난수가 생성
        System.out.println("당첨번호: ");
        for (int i = 0; i < 6; i++) {
            winningNumber[i] = random.nextInt(45) + 1;
            System.out.print(winningNumber[i] + " ");
        }
        System.out.println("\n");

        // 당첨여부, 비교하기 전에 배열 항목을 정렬
        Arrays.sort(selectNumber); // selectNumber 배열의 요소들을 오름차순으로 정렬
        Arrays.sort(winningNumber); // winningNumber 배열의 요소들을 오름차순으로 정렬
        // 정렬된 selectNumber 배열과 winningNumber 배열을 비교하여 두 배열이 같은지 확인
        // 두 배열의 요소들이 모두 같다면 true 를 반환하고, 그렇지 않으면 false 를 반환
        boolean result = Arrays.equals(selectNumber, winningNumber); // 배열 항목 비교
        System.out.println("당첨여부: ");
        if (result) {
            System.out.println("1등에 당첨되셨습니다.");
        } else {
            System.out.println("당첨되지 않았습니다.");
        }
    }
}
