package refactoring.chapter1;

public class TragedyCalculator extends PerformanceCalculator {
    public TragedyCalculator(Performance performance, Play play) {
        super(performance, play);
    }

    @Override
    public int amount() {
        int result = 40000;

        if (super.getPerformance().getAudience() > 30) {
            result += 1000 * (super.getPerformance().getAudience() - 30);
        }

        return result;
    }
}
