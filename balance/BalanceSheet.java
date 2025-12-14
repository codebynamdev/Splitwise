package balance;

import model.User;

import java.util.HashMap;
import java.util.Map;

public class BalanceSheet {
    private Map<User, Map<User, Double>>balances;

    public Map<User, Map<User, Double>> getBalances() {
        return balances;
    }

    public void addDebt(User from, User to, double amount) {
        if(!balances.containsKey(from)) {
            balances.put(from, new HashMap<>());
        }
        Map<User, Double>fromMap = balances.get(from);
        if(fromMap.containsKey(to)) {
            fromMap.put(to, (fromMap.get(to) + amount));
        }
        else fromMap.put(to, amount);
    }
}
