package model;

import java.util.List;

public class Expense {
    private int expenseId;
    private String description;
    private double amount;
    private User paidBy;
    private List<Split>splits;


    public Expense(int expenseId, String description, double amount, User paidBy, List<Split>splits) {
        this.expenseId = expenseId;
        this. description = description;
        this.amount = amount;
        this.paidBy = paidBy;
        this.splits = splits;
    }
    public double getAmount() {
        return amount;
    }
    public List<Split> getSplits() {
        return splits;
    }
    public User getPaidBy(){ return paidBy; }


}
