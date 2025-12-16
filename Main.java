import balance.BalanceSheet;
import balance.DebtSimplifier;
import balance.Settlement;
import model.*;
import service.ExpenseService;
import Strategy.EqualSplitStrategy;
import Strategy.ExactSplitStrategy;
import Strategy.PercentSplitStrategy;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // 1️⃣ Create Users
        User u1 = new User(1, "Aman");
        User u2 = new User(2, "Rahul");
        User u3 = new User(3, "Rohit");

        // 2️⃣ Create Balance Sheet
        BalanceSheet balanceSheet = new BalanceSheet();

        // 3️⃣ Create Expense Service
        ExpenseService expenseService = new ExpenseService(balanceSheet);

        // ================== EQUAL SPLIT ==================
        List<Split> equalSplits = new ArrayList<>();
        equalSplits.add(new EqualSplit(u1));
        equalSplits.add(new EqualSplit(u2));
        equalSplits.add(new EqualSplit(u3));

        Expense equalExpense = new Expense(
                101,
                "Dinner",
                300,
                u1,
                equalSplits
        );

        expenseService.addExpense(equalExpense, new EqualSplitStrategy());

        // ================== EXACT SPLIT ==================
        List<Split> exactSplits = new ArrayList<>();
        exactSplits.add(new ExactSplit(u1, 100));
        exactSplits.add(new ExactSplit(u2, 150));
        exactSplits.add(new ExactSplit(u3, 50));

        Expense exactExpense = new Expense(
                102,
                "Movie",
                300,
                u2,
                exactSplits
        );

        expenseService.addExpense(exactExpense, new ExactSplitStrategy());

        // ================== PERCENT SPLIT ==================
        List<Split> percentSplits = new ArrayList<>();
        percentSplits.add(new PercentSplit(u1, 40));
        percentSplits.add(new PercentSplit(u2, 30));
        percentSplits.add(new PercentSplit(u3, 30));

        Expense percentExpense = new Expense(
                103,
                "Trip",
                1000,
                u3,
                percentSplits
        );

        expenseService.addExpense(percentExpense, new PercentSplitStrategy());

        // ================== SIMPLIFY BALANCES ==================
        DebtSimplifier simplifier = new DebtSimplifier();
        List<Settlement> settlements = simplifier.simplify(balanceSheet);

        // ================== PRINT RESULT ==================
        System.out.println("\nFinal Settlements:");
        for (Settlement s : settlements) {
            System.out.println(
                    s.getFrom().getUserId() + " pays " +
                            s.getTo().getUserId() + " amount " +
                            s.getAmount()
            );
        }
    }
}
