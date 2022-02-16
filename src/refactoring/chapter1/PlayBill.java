package refactoring.chapter1;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class PlayBill {
        private static Invoice invoice = new Invoice("BigCo");
        private static Map<String, Play> plays = new HashMap<>() {{
            put("hamlet", new Play("Hamlet", "tragedy"));
            put("as-like", new Play("As You Like It", "comedy"));
            put("othello", new Play("Othello", "tragedy"));
        }};

    public static void main(String[] args) {
        String text = statement(invoice, plays);
        System.out.println(text);
    }

    public static String statement(Invoice invoice, Map<String, Play> plays) {
        int totalAmount = 0;

        String result = "청구내역 (고객명: " + invoice.getCustomer() + ")\n";

        for (Performance performance : invoice.getPerformance()) {
            // 청구 내역을 출력한다
            result += playFor(performance).getName() + ": " + usd(amountFor(performance)) + "(" + performance.getAudience() + "석)\n";
            totalAmount += amountFor(performance);
        }

        int volumeCredits = totalVolumeCredits();
        result += "총액: " + usd(totalAmount) + "\n";
        result += "적립포인트: " + volumeCredits + "점\n";
        return result;
    }

    private static int totalVolumeCredits() {
        int volumeCredits = 0;
        for (Performance performance : invoice.getPerformance()) {
            // 포인트를 적립한다
            volumeCredits += volumeCreditsFor(performance);
        }
        return volumeCredits;
    }

    private static int volumeCreditsFor(Performance performance) {
        int volumeCredits = 0;
        volumeCredits += Math.max(performance.getAudience() - 30, 0);
        if ("comedy".equals(playFor(performance).getType())) {
            volumeCredits += Math.floor(performance.getAudience() / 5);
        }
        return volumeCredits;
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
