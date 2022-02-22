package refactoring.chapter1;

import java.util.List;

public class Invoice {
    private String customer;
    private List<Performance> performances;

    public Invoice(String customer) {
        this.customer = customer;
        performances = Performance.createTestPerformanceData();
    }

    public String getCustomer() {
        return customer;
    }

    public List<Performance> getPerformance() {
        return performances;
    }
}
