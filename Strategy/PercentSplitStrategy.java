package Strategy;

import model.Expense;
import model.PercentSplit;
import model.Split;

import java.util.List;

public class PercentSplitStrategy implements SplitStrategy{
    double sum = 0;
    @Override
    public void calculate(Expense expense) {
        List<Split>splits = expense.getSplits();
        double totalAmount = expense.getAmount();
        for(Split split : splits) {
            PercentSplit percentSplit = (PercentSplit) split;
            double percent = percentSplit.getPercent();
            double userAmount = (totalAmount*percent)/100;
            sum+=userAmount;
            split.setAmount(userAmount);
        }
        if(sum!=expense.getAmount()) {
            throw new IllegalArgumentException("Total amount do not match with the percentage amounts");
        }
    }
}
