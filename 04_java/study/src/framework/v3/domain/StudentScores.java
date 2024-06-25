package framework.v3.domain;

// 데이터 관리를 App 로 부터 분리 : 싱글톤 패턴 적용
// 각 명령을 클래스로 추상화 : Command 패턴 적용
public class StudentScores {
    int studentNum = 0;
    int[] scores = null;

    // Singleton 패턴
    private StudentScores() { }

    private static StudentScores instance = new StudentScores();

    public static StudentScores getInstance() {
        return instance;
    }

    public int getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(int studentNum) {
        this.studentNum = studentNum;
        this.scores = new int[studentNum];
    }

    public int[] getScores() {
        return scores;
    }
}
