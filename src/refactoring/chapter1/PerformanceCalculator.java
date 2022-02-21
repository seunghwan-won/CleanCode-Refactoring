package refactoring.chapter1;

public class PerformanceCalculator {
    private final Performance performance;
    private final Play play;

    public PerformanceCalculator(Performance performance, Play play) {
        this.performance = performance;
        this.play = play;
    }

    public static PerformanceCalculator create(Performance performance, Play play) {
        switch (play.getType()) {
            case "tragedy":
                return new TragedyCalculator(performance, play);
            case "comedy":
                return new ComedyCalculator(performance, play);
            default:
                throw new RuntimeException("알 수 없는 장르 : " + play.getType());
        }
    }

    public int amount() {
        throw new IllegalCallerException("서브클래스에서 처리하도록 변경되었습니다.");
    }

    public int volumeCredits() {
        int result = 0;
        result += Math.max(performance.getAudience() - 30, 0);
        return result;
    }

    public Performance getPerformance() {
        return performance;
    }

    public Play getPlay() {
        return play;
    }
}
