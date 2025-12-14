package Strategy;

import model.Expense;

public interface SplitStrategy {
    void calculate(Expense expense);
}
