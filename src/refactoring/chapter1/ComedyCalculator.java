package refactoring.chapter1;

public class ComedyCalculator extends PerformanceCalculator {
    public ComedyCalculator(Performance performance, Play play) {
        super(performance, play);
    }

    @Override
    public int amount() {
        int result = 30000;

        if (super.getPerformance().getAudience() > 20) {
            result += 10000 + 500 * (super.getPerformance().getAudience() - 20);
        }

        result += 300 * super.getPerformance().getAudience();
        return result;
    }

    @Override
    public int volumeCredits() {
        int result = 0;
        result += Math.max(super.getPerformance().getAudience() - 30, 0);
        if ("comedy".equals(super.getPlay().getType())) {
            result += Math.floor(super.getPerformance().getAudience() / 5);
        }
        return result;
    }
}
