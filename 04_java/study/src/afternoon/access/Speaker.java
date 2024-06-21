package afternoon.access;

public class Speaker {
    private int volume;
    private int MAX_VOLUME = 100;
    private int MIN_VOLUME = 0;

    public Speaker() { // 기본 볼륨 : 20
        this.volume = 20;
    }

    public void volumeUp() { // 볼륨 1 증가
        if (maxVolume()) {
            this.volume += 1;
//            this.volume++;
        } else {
            printLimit();
        }
    }

    public void volumeDown() { // 볼륨 1 감소
        if (minVolume()) {
            this.volume -= 1;
//            this.volume--;
        } else {
            printLimit();
        }
    }
    private boolean minVolume() { // 최소값 0
        return this.volume > MIN_VOLUME;
    }

    private boolean maxVolume() { // 최대값 100
        return this.volume < MAX_VOLUME;
    }

    private void mute() { // mute() 호출하면 음소거 되고 아래 문구 출력
        this.volume = 0;
        System.out.println("스피커가 Mute 되었습니다.");
    }

    private void printLimit() {
        System.out.println("더 이상 볼륨 조질이 불가능합니다.");
    }
}
