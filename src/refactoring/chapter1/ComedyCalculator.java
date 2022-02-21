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
}
