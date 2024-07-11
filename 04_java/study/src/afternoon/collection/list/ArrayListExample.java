package afternoon.collection.list;

public class ArrayListExample {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        // 배열 제일 뒤에 6을 추가해 주세요!
        int[] temp = new int[arr.length + 1];

        for (int i = 0; i < arr.length; i++) { // 기존 배열을 새 배열에 복사
            temp[i] = arr[i]; // 깊은 복사
        }

        temp[temp.length - 1] = 6;
        arr = temp;

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
;}
