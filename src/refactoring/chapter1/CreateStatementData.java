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
            PerformanceCalculator calculator = new PerformanceCalculator(performance, playFor(performance));
            performance.setPlay(calculator.getPlay());
            performance.setAmount(calculator.amount());
            performance.setVolumeCredits(calculator.volumeCredits());
            result.add(performance);
        }
        return result;
    }

    private static int totalAmount(StatementData statementDate) {
        return statementDate.getPerformance().stream().mapToInt((performance) -> performance.getAmount()).sum();
    }

    private static int totalVolumeCredits(StatementData statementDate) {
        return statementDate.getPerformance().stream().mapToInt((performance) -> performance.getVolumeCredit()).sum();
    }

    private static Play playFor(Performance performance) {
        return plays.get(performance.getPlayID());
    }
}
