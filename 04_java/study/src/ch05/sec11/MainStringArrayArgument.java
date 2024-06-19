package ch05.sec11;

public class MainStringArrayArgument {
    public static void main(String[] args) {
        // String[] args 매개변수, 프로그램 실행 시 입력 값이 부족하면 길이가 0인 String 배열 참조
        if(args.length != 2) {
            System.out.println("프로그램 입력값이 부족");
            System.exit(0);
        }

        String strNum1 = args[0];
        String strNum2 = args[1];

        int num1 = Integer.parseInt(strNum1);
        int num2 = Integer.parseInt(strNum2);

        int result = num1 + num2;
        System.out.println(num1 + " + " + num2 + " = " + result);
    }
}
