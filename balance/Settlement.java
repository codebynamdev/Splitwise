package balance;

import model.User;

public class Settlement {
    private User from;
    private User to;
    private double amount;
    public Settlement(User from, User to, double amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }
    public User getFrom() {
        return from;
    }
    public User getTo() {
        return to;
    }
    public double getAmount() {
        return amount;
    }
}
