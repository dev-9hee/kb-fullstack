package afternoon.exception.basic;

public class ExceptionWithout2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        if (accessArr(arr, 6)) {
            System.out.println("배열 접근이 가능합니다!");
            System.out.println("원하던 작업을 이어 갑니다!");

            Object obj = null;

            if (!accessNull(obj)) {
                System.out.println("객체가 null 이 아닙니다!");
                System.out.println("원하던 작업을 이어 갑니다!");
            } else {
                System.out.println("객체가 비었습니다. 에러를 발생 시킵니다.");
            }
        } else {
            System.out.println("배열 접근이 불가능 합니다. 에러 발생");
        }
    }

    // 배열과 idx 를 받아서 해당 값에 접근이 가능한지 확인하는 메서드
    public static boolean accessArr(int[] arr, int idx) {
        if (idx < arr.length) {
            return true;
        } else {
            return false;
        }
    }

    // 전달 받은 객체가 비었는지 안 비었는지 확인하는 메서드
    // 어떤 모든 객체를 받기 위해 Object 타입으로 받음
    public static boolean accessNull(Object obj) {
        if (obj == null) {
            return true;
        } else {
            return false;
        }
    }
}
