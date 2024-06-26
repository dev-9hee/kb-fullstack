package cond.ex;

// 문제 : 평점에 따른 영화 추천하기
// 요청한 평점 이상의 영화를 찾아서 추천하는 프로그램을 작성
// 어바웃타임 - 평점9, 토이 스토리 - 평점8, 고질라 - 평점7
public class MoveRateEx {

    public static void main(String[] args) {
        double rating = 7.1; // 평점 변수

        // 여러개가 출력되어야 되기 때문에 if 문을 묶으면 안 됨
        if (rating <= 9) {
            System.out.println("'어바웃타임'을 추천합니다.");
        }
        if (rating <= 8) {
            System.out.println("'토이 스토리'를 추천합니다.");
        }
        if (rating <= 7) {
            System.out.println("'고질라'를 추천합니다.");
        }
    }
}
