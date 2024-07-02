package afternoon.lang.math.lotto;

public class LottoMain {
    public static void main(String[] args) {
        LottoGenerator lottoGenerator = new LottoGenerator();

        lottoGenerator.generate();
        lottoGenerator.printLottoNumbers();
    }
}
