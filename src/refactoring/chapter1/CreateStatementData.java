package refactoring.chapter1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateStatementData {
    private static Map<String, Play> plays = new HashMap<>() {{
        put("hamlet", new Play("Hamlet", "tragedy"));
        put("as-like", new Play("As You Like It", "comedy"));
        put("othello", new Play("Othello", "tragedy"));
    }};

    public static StatementData create(Invoice invoice) {
        StatementData statementDate = new StatementData();
        statementDate.setCustomer(invoice.getCustomer());
        statementDate.setPerformance(enrichPerformance(invoice.getPerformance()));
        statementDate.setTotalAmount(totalAmount(statementDate));
        statementDate.setTotalVolumeCredit(totalVolumeCredits(statementDate));
        return statementDate;
    }

    private static List<Performance> enrichPerformance(List<Performance> performances) {
        List<Performance> result = new ArrayList<>();
        for (Performance performance : performances) {
            performance.setPlay(playFor(performance));
            performance.setAmount(amountFor(performance));
            performance.setVolumeCredits(volumeCreditsFor(performance));
            result.add(performance);
        }
        return result;
    }

    private static int totalAmount(StatementData statementDate) {
        return statementDate.getPerformance().stream().mapToInt((performance) -> performance.getAmount()).sum();
    }

    private static int volumeCreditsFor(Performance performance) {
        int result = 0;
        result += Math.max(performance.getAudience() - 30, 0);
        if ("comedy".equals(playFor(performance).getType())) {
            result += Math.floor(performance.getAudience() / 5);
        }
        return result;
    }

    private static int totalVolumeCredits(StatementData statementDate) {
        return statementDate.getPerformance().stream().mapToInt((performance) -> performance.getVolumeCredit()).sum();
    }

    private static int amountFor(Performance performance) {
        int result = 0;
        switch (playFor(performance).getType()) {
            case "tragedy":
                result = 40000;
                if (performance.getAudience() > 30) {
                    result += 1000 * (performance.getAudience() - 30);
                }
                break;
            case "comedy":
                result = 30000;
                if (performance.getAudience() > 20) {
                    result += 10000 + 500 * (performance.getAudience() - 20);
                }
                result += 300 * performance.getAudience();
                break;
            default:
                throw new RuntimeException("알 수 없는 장르 : " + playFor(performance).getType());
        }
        return result;
    }

    private static Play playFor(Performance performance) {
        return plays.get(performance.getPlayID());
    }
}
