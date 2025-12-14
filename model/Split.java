package model;

abstract public class Split {
    private User user;
    private double amount;
    public Split(User user){
        this.user=user;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public double getAmount() {
        return amount;
    }
    public User getUser() {
        return user;
    }
}
