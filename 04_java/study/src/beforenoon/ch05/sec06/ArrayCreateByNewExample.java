package beforenoon.ch05.sec06;

// new 연산자로 배열 생성
public class ArrayCreateByNewExample {
    public static void main(String[] args) {
        // 배열 변수 선언과 배열 생성
        int[] arr1 = new int[3];
        double[] arr2 = new double[3];

        // 배열 항목의 초기값 출력
        for (int i = 0; i < arr1.length; i++) {
            System.out.print("arr1[" + i + "] : " + arr1[i] + ", ");
        }
        System.out.println(); // 다음 줄로

        // 배열 항목의 값 변경
        arr1[0] = 10;
        arr1[1] = 20;
        arr1[2] = 30;

        // 배열 항목의 변경 값 출력
        for (int i = 0; i < arr1.length; i++) {
            System.out.print("arr1[" + i + "] : " + arr1[i] + ", ");
        }
        System.out.println("\n"); // 다음 줄 and 한 줄 비우기

        // 배열 항목의 초기값 출력
        for (int i = 0; i < arr2.length; i++) {
            System.out.print("arr2[" + i + "] : " + arr2[i] + ", ");
        }
        System.out.println();

        // 배열 항목의 값 변경
        arr2[0] = 0.1;
        arr2[1] = 0.2;
        arr2[2] = 0.3;

        // 배열 항목의 변경 값 출력
        for (int i = 0; i < arr2.length; i++) {
            System.out.print("arr2[" + i + "] : " + arr2[i] + ", ");
        }
        System.out.println("\n");
    }
}
