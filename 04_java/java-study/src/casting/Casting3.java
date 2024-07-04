package casting;

public class Casting3 {
    public static void main(String[] args) {
        long maxIntValue = 2147483647; // int 최고값
        long maxIntOver = 2147483648L; // int 최고값 + 1(초과)
        int intValue = 0;

        intValue = (int) maxIntValue; // 형변환
        System.out.println("maxIntValue casting = " + intValue); // maxIntValue casting = 2147483647

        intValue = (int) maxIntOver; // 형변환
        System.out.println("maxIntOver casting= " + intValue); // int 최고값을 넘으니 처음부터 다시 시작 => 오버플로우
        // 출력: maxIntOver casting= -2147483648
    }
}
