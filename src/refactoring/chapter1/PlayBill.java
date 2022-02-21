package refactoring.chapter1;

import java.text.NumberFormat;
import java.util.Locale;

public class PlayBill {
    private static Invoice invoice = new Invoice("BigCo");


    public static void main(String[] args) {
        System.out.println(statement(invoice));
        System.out.println(htmLStatement(invoice));
    }

    public static String statement(Invoice invoice) {
        return renderPlainText(CreateStatementData.create(invoice));
    }

    public static String htmLStatement(Invoice invoice) {
        return renderHtml(CreateStatementData.create(invoice));
    }

    private static String renderHtml(StatementData statementData) {
        String result = "<h1>청구 내역 (고객명: " + statementData.getCustomer() + ")</h1>\n";
        result += "<table>\n";
        result += "    <tr><th>연극</th><th>좌석 수</th><th>금액</th></tr>\n";

        for (Performance performance : statementData.getPerformance()) {
            result += "    <tr><td>" + performance.getPlay().getName() + "</td></tr>(" + performance.getAudience() +
                    "석)</td>";
            result += "<td>" + usd(performance.getAmount()) + "</td></tr>\n";
        }

        result += "</table>\n";
        result += "<p>총액: <em>" + usd(statementData.getTotalAmount()) + "</em></p>\n";
        result += "<p>적립 포인트: <em>" + statementData.getTotalVolumeCredit() + "</em>점</p>\n";
        return result;
    }

    private static String renderPlainText(StatementData statementDate) {
        String result = "청구내역 (고객명: " + statementDate.getCustomer() + ")\n";

        for (Performance performance : statementDate.getPerformance()) {
            // 청구 내역을 출력한다
            result += performance.getPlay().getName() + ": " + usd(performance.getAmount()) + "(" + performance.getAudience() + "석)\n";
        }

        result += "총액: " + usd(statementDate.getTotalAmount()) + "\n";
        result += "적립포인트: " + statementDate.getTotalVolumeCredit() + "점\n";
        return result;
    }

    private static String usd(int number) {
        Locale locale = Locale.US;
        return NumberFormat.getCurrencyInstance(locale).format(number / 100);
    }
}
