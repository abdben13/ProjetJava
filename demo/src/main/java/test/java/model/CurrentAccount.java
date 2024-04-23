package test.java.model;

public class CurrentAccount extends BankAccount{
    private double overDraft;

    public CurrentAccount() {
        super();
        }

    public CurrentAccount(String currency, double initialBalance, double overDraft){
        super(currency, initialBalance);
        this.overDraft = overDraft;
    }

    @Override
    public String toString() {
        return "CurrentAccount{" +
                "overDraft=" + overDraft +
                "} " + super.toString();
    }

    public void setOverDraft(double overDraft) {
        this.overDraft = overDraft;
    }

    public double getOverDraft() {
        return overDraft;
    }

    @Override
    public String getType() {
        return "Current_Account";
    }
}
