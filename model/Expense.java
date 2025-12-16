package model;

import java.util.List;

public class Expense {

    private final int expenseId;
    private final String description;
    private final double amount;
    private final User paidBy;
    private final List<Split> splits;

    public Expense(int expenseId, String description, double amount, User paidBy, List<Split> splits) {
        this.expenseId = expenseId;
        this.description = description;
        this.amount = amount;
        this.paidBy = paidBy;
        this.splits = splits;
    }

    public int getExpenseId() {
        return expenseId;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public List<Split> getSplits() {
        return splits;
    }
}
