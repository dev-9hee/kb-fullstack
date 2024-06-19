package ch05.sec09;

public class ArrayCopyByForEx {
    public static void main(String[] args) {
        // 길이 3인 배열
        int[] oldIntArray = { 1, 2, 3};
        // 길이 5인 배열을 새로 생성
        int[] newIntArray = new int[5];
        // 배열 항목 복사
        for (int i = 0; i < oldIntArray.length; i++) {
            newIntArray[i] = oldIntArray[i];
        }
        // 배열 항목 출력
        for (int i = 0; i < newIntArray.length; i++) {
            System.out.print(newIntArray[i] + ", "); // 1, 2, 3, 0, 0
        }
    }
}
