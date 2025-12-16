package balance;

import model.User;
import java.util.*;

public class DebtSimplifier {

    public List<Settlement> simplify(BalanceSheet balance) {

        Map<User, Map<User, Double>> balances = balance.getBalances();
        Map<User, Double> netBalance = getNetBalance(balances);

        PriorityQueue<Map.Entry<User, Double>> positive =
                new PriorityQueue<>((a, b) -> Double.compare(b.getValue(), a.getValue()));

        PriorityQueue<Map.Entry<User, Double>> negative =
                new PriorityQueue<>((a, b) -> Double.compare(a.getValue(), b.getValue()));

        for (Map.Entry<User, Double> entry : netBalance.entrySet()) {
            if (entry.getValue() > 0) positive.add(entry);
            else if (entry.getValue() < 0) negative.add(entry);
        }

        List<Settlement> settlements = new ArrayList<>();

        while (!positive.isEmpty() && !negative.isEmpty()) {

            Map.Entry<User, Double> creditor = positive.poll();
            Map.Entry<User, Double> debtor = negative.poll();

            double settleAmount = Math.min(
                    creditor.getValue(),
                    -debtor.getValue()
            );

            settlements.add(
                    new Settlement(debtor.getKey(), creditor.getKey(), settleAmount)
            );

            creditor.setValue(creditor.getValue() - settleAmount);
            debtor.setValue(debtor.getValue() + settleAmount);

            if (creditor.getValue() > 0) positive.add(creditor);
            if (debtor.getValue() < 0) negative.add(debtor);
        }

        return settlements;
    }

    private Map<User, Double> getNetBalance(Map<User, Map<User, Double>> balances) {

        Map<User, Double> netBalance = new HashMap<>();

        for (Map.Entry<User, Map<User, Double>> entry : balances.entrySet()) {
            User from = entry.getKey();
            for (Map.Entry<User, Double> debt : entry.getValue().entrySet()) {
                User to = debt.getKey();
                double amount = debt.getValue();

                netBalance.put(from, netBalance.getOrDefault(from, 0.0) - amount);
                netBalance.put(to, netBalance.getOrDefault(to, 0.0) + amount);
            }
        }
        return netBalance;
    }
}
