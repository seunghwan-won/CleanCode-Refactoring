package refactoring.chapter1;

import java.util.Arrays;
import java.util.List;

public class Performance {
    private String playID;
    private int audience;

    public Performance(String playID, int audience) {
        this.playID = playID;
        this.audience = audience;
    }

    public static List<Performance> createTestPerformanceData() {
        return Arrays.asList(new Performance("hamlet", 55),
                new Performance("as-like", 35), new Performance("othello", 40));
    }

    public String getPlayID() {
        return playID;
    }

    public int getAudience() {
        return audience;
    }
}
