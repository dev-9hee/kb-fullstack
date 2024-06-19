package afternoon.classs;

public class FishBreadMain { // 운영 클래스
    public static void main(String[] args) {
        // 생성자에게 각각의 매개변수를 전달하여 새롭게 생성되는 인스턴스의 초기값을 지정
        FishBread fish1 = new FishBread("마라맛", "상어", 3000); // 새로운 객체르 만듦, 주소값을 fish1에 담음
        fish1.printFishBread();

        System.out.println(); // 빈 줄 삽입

        FishBread fish2 = new FishBread();
        fish2.printFishBread();
    }
}
