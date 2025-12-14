package Strategy;

import model.ExactSplit;
import model.Expense;
import model.Split;

import java.util.List;

public class ExactSplitStrategy implements SplitStrategy{
    double sum = 0;
    @Override
    public void calculate(Expense expense) {
        List<Split>splits = expense.getSplits();
        for(Split split : splits) {
            ExactSplit exactSplit = (ExactSplit)split;
            sum+=exactSplit.getExactAmount();
            split.setAmount(exactSplit.getExactAmount());
        }
        if(sum!=expense.getAmount()) {
            throw new IllegalArgumentException("total amount do not match with the exact amounts");
        }
    }
}
