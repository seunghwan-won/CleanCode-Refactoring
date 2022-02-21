package refactoring.chapter1;

import java.util.List;

public class StatementData {
    private String customer;
    public List<Performance> performance;
    private int totalAMount;
    private int totalVolumeCredit;

    public StatementData() {

    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public void setPerformance(List<Performance> performance) {
        this.performance = performance;
    }

    public String getCustomer() {
        return customer;
    }

    public List<Performance> getPerformance() {
        return performance;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAMount = totalAmount;
    }

    public int getTotalAmount() {
        return totalAMount;
    }

    public void setTotalVolumeCredit(int totalVolumeCredit) {
        this.totalVolumeCredit = totalVolumeCredit;
    }

    public int getTotalVolumeCredit() {
        return totalVolumeCredit;
    }
}
