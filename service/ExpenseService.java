package service;

import balance.BalanceSheet;
import model.Expense;
import model.Split;
import model.User;
import Strategy.SplitStrategy;

public class ExpenseService {

    private final BalanceSheet balanceSheet;

    public ExpenseService(BalanceSheet balanceSheet) {
        this.balanceSheet = balanceSheet;
    }

    public void addExpense(Expense expense, SplitStrategy splitStrategy) {
        splitStrategy.calculate(expense);

        User paidBy = expense.getPaidBy();

        for (Split split : expense.getSplits()) {
            User user = split.getUser();
            double amount = split.getAmount();

            // skip self payment
            if (!user.equals(paidBy)) {
                balanceSheet.addDebt(user, paidBy, amount);
            }
        }
    }
}