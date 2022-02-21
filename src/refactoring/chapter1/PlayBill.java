package refactoring.chapter1;

import java.text.NumberFormat;
import java.util.Locale;

public class PlayBill {
    private static Invoice invoice = new Invoice("BigCo");


    public static void main(String[] args) {
        System.out.println(statement(invoice));
    }

    public static String statement(Invoice invoice) {
        return renderPlainText(CreateStatementData.create(invoice));
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

    private static String usd(int number) {
        Locale locale = Locale.US;
        return NumberFormat.getCurrencyInstance(locale).format(number / 100);
    }
}
