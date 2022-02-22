package refactoring.chapter1;

import java.util.Arrays;
import java.util.List;

public class Performance {
    private String playID;
    private int audience;
    private Play play;
    private int amount;
    private int volumeCredit;

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

    public void setPlay(Play play) {
        this.play = play;
    }

    public Play getPlay() {
        return play;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setVolumeCredits(int volumeCredit) {
        this.volumeCredit = volumeCredit;
    }
    public int getVolumeCredit() {
        return volumeCredit;
    }
}
