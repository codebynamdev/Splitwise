package model;

public class ExactSplit extends Split{
    private double exactAmount;
    public ExactSplit(User user, double exactAmount) {
        super(user);
        this.exactAmount=exactAmount;
    }
    public double getExactAmount() {
        return exactAmount;
    }
}
