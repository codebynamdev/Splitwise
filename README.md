# Splitwise

Folder Structure: 
splitwise/
│
├── model/
│   ├── User.java
│   ├── Group.java
│   ├── Expense.java
│   ├── Split.java
│   ├── EqualSplit.java
│   ├── ExactSplit.java
│   ├── PercentSplit.java
│
├── strategy/
│   ├── SplitStrategy.java
│   ├── EqualSplitStrategy.java
│   ├── ExactSplitStrategy.java
│   ├── PercentSplitStrategy.java
│
├── balance/
│   ├── BalanceSheet.java
│   ├── DebtSimplifier.java   (optional)
│
├── service/
│   ├── ExpenseService.java
│   ├── GroupService.java
│   ├── UserService.java
│
├── exceptions/
│   ├── InvalidSplitException.java
│   ├── InvalidExpenseException.java
│
├── util/
│   ├── IdGenerator.java
│
└── Main.java

 objects: 
 1. User {
    id, name, contact number
 }
 2. Group {
    id, name, List<user>, List<Expense>
    Behaviour {
        addExpenses()
        updateExpense()
        addMember()
        removeMember()
    }
 }
 3. Expense{
    id, description, amount, paidBy(User), Participants(List<User>),splitStrategy
    behaviour{
        calculateShares() according to splitStrategy
    } 
 }
