package beforenoon.ch17.sec07.exam01;

public class Student implements Comparable<Student> {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() { return name; }
    public int getScore() { return score; }

    // 이 메서드는 두 Student 객체를 비교하여 정수 값을 반환
    // 여기서는 score 필드를 기준으로 비교하여 점수가 높은 학생이 먼저 오도록 정렬
    @Override
    public int compareTo(Student o) {
        return Integer.compare(score, o.score);
    }
    // score 가 o.score 보다 작으면 음수값이 반환됩니다.
    // score 가 o.score 와 같으면 0이 반환됩니다.
    // score 가 o.score 보다 크면 양수값이 반환됩니다.
}
