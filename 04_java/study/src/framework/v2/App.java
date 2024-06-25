package framework.v2;

public class App {
    int studentNum = 0;
    int[] scores = null;

    boolean run = true;
    Menu menu;

    public App() {
        menu = new Menu();
    }

    private void analize() {
        int max = 0;
        int sum = 0;
        double avg = 0;
        for (int i = 0; i < scores.length; i++) {
            max = (max<scores[i]) ? scores[i] : max;
            sum += scores[i];
        }
        avg = (double) sum / studentNum;
        System.out.println("최고 점수: " + max);
        System.out.println("평균 점수: " + avg);
    }

    public void getStudentNum() {
        System.out.print("학생수> ");
        scores = new int[studentNum]; // 학생 수 크기의 scores 배열을 생성
    }

    public void getScores() {
        for (int i = 0; i < scores.length; i++) {
            System.out.print("scores[" + i + "]> ");
        }
    }

    public void printScore() {
        for (int i = 0; i < scores.length; i++) {
            System.out.println("scores[" + i + "]: " + scores[i]);
        }
    }

    public void exit() {
        run = false;
    }

    public void executeCommand(int selectNo) { // OCP 위배, 안 좋은 코드!!
        // 연속된 숫자 => 배열의 인덱스로 매핑 가능
        if(selectNo == 1) {
            getStudentNum();
        } else if(selectNo == 2) {
            getScores();
        } else if(selectNo == 3) {
            printScore();
        } else if(selectNo == 4) {
            analize();
        } else if(selectNo == 5) {
            exit();
        }
    }

    public void run() {
        while (run) {
            menu.printMenu();
            int selectNo = menu.getSelect();
            executeCommand(selectNo);
        }
    }
    public static void main(String[] args) {
        framework.v1.App app = new framework.v1.App();
        app.run();
    }
}
