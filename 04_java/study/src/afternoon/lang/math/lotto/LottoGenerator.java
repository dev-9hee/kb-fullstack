package afternoon.lang.math.lotto;

import java.util.Random;

// 로또 번호 생성 클래스
public class LottoGenerator {
    Random random = new Random();

    int[] lottoNumbers = new int[6];

    public void generate() {
        boolean[] isUsed = new boolean[46]; // 1 ~ 45 번호 사용 여부 기록

        int count = 0;
        while (count < 6) { // 랜덤 번호 6개 생성
            int randNum = random.nextInt(45) + 1; // 1 ~ 45 사이의 랜덤 숫자 생성
            if (!isUsed[randNum]) { // 해당 번호가 아직 사용되지 않았다면
                lottoNumbers[count] = randNum;
                isUsed[randNum] = true; // 해당 번호 사용 표시
                count++;
            }
        }

//        for (int i = 0; i < lottoNumbers.length; i++) {
//            int randNum; // 랜덤 생성된 숫자를 변수 선언
//            do {
//                randNum = random.nextInt(45) + 1; // 1 ~ 45 사이의 랜덤 숫자 생성
//            } while (isUsed[randNum]); // 이미 사용된 번호라면 다시 생성
//
//            lottoNumbers[i] = randNum;
//            isUsed[randNum] = true; // 해당 번호 사용 표시
//        }
    }

    public void printLottoNumbers() {
        System.out.print("로또 번호 : ");
        for (int i = 0; i <lottoNumbers.length ; i++) {
            System.out.print(lottoNumbers[i] + " ");
        }
    }
}
