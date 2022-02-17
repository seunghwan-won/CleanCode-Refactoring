package refactoring.chapter1;

import java.text.NumberFormat;
import java.util.*;
import java.util.stream.Stream;

public class PlayBill {
    private static Invoice invoice = new Invoice("BigCo");
    private static Map<String, Play> plays = new HashMap<>() {{
        put("hamlet", new Play("Hamlet", "tragedy"));
        put("as-like", new Play("As You Like It", "comedy"));
        put("othello", new Play("Othello", "tragedy"));
    }};

    public static void main(String[] args) {
        System.out.println(statement(invoice));
    }

    public static String statement(Invoice invoice) {
        StatementData statementDate = new StatementData();
        statementDate.setCustomer(invoice.getCustomer());
        statementDate.setPerformance(enrichPerformance(invoice.getPerformance()));
        statementDate.setTotalAmount(totalAmount(statementDate));
        statementDate.setTotalVolumeCredit(totalVolumeCredits(statementDate));
        return renderPlainText(statementDate);
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

    private static String renderPlainText(StatementData statementDate) {
        String result = "청구내역 (고객명: " + statementDate.getCustomer() + ")\n";

        for (Performance performance : statementDate.getPerformance()) {
            // 청구 내역을 출력한다
            result += performance.getPlay().getName() + ": " + usd(performance.getAmount()) + "(" + performance.getAudience() + "석)\n";
        }

        result += "총액: " + usd(statementDate.getTotalAMount()) + "\n";
        result += "적립포인트: " + statementDate.getTotalVolumeCredit() + "점\n";
        return result;
    }

    private static int totalAmount(StatementData statementDate) {
        return statementDate.getPerformance().stream().mapToInt((performance) -> performance.getAmount()).sum();
    }

    private static int totalVolumeCredits(StatementData statementDate) {
        return statementDate.getPerformance().stream().mapToInt((performance) -> performance.getVolumeCredit()).sum();
    }

    private static int volumeCreditsFor(Performance performance) {
        int result = 0;
        result += Math.max(performance.getAudience() - 30, 0);
        if ("comedy".equals(playFor(performance).getType())) {
            result += Math.floor(performance.getAudience() / 5);
        }
        return result;
    }

    private static Play playFor(Performance performance) {
        return plays.get(performance.getPlayID());
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

    private static String usd(int number) {
        Locale locale = Locale.US;
        return NumberFormat.getCurrencyInstance(locale).format(number / 100);
    }
}
