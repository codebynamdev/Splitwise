package Strategy;

import model.Expense;
import model.Split;
import model.User;

import java.util.List;

public class EqualSplitStrategy implements SplitStrategy{
    @Override
    public void calculate(Expense expense) {
            double totalAmount = expense.getAmount();
            List<Split> splits= expense.getSplits();
            int numberOfUsers = splits.size();
            double sharedAmount = totalAmount/numberOfUsers;
            for(Split split:splits) {
                split.setAmount(sharedAmount);
            }
    }
}
