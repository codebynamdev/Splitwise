# Splitwise
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
