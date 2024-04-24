package test.java.model;

import java.util.UUID;

public abstract class BankAccount extends Object{
    private String accountId;
    private double balance;
    private String currency;
    private AccountStatus status;
    private String name;

    public BankAccount() {
        this.accountId = UUID.randomUUID().toString();
        this.status = AccountStatus.CREATED;
        this.balance = 0.0;
        this.currency = "EUR";
    }

    public BankAccount(String currency, double initialBalance){
        this();
        this.balance = initialBalance;
        this.currency = currency;
    }

    public String getAccountId() {
        return accountId;
    }
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public String getCurrency() {
        return currency;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }
    public AccountStatus getStatus() {
        return status;
    }
    public void setStatus(AccountStatus status) {
        this.status = status;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "BankAccount{" +
        "accountId='" + accountId + '\'' +
        ", balance=" + balance +
        ", currency='" + currency + '\'' +
        ", status=" + status + 
        ", name='" + name + '\'' +'}';
    }

    public abstract String getType();
    public final void print(){
        System.out.println("-------------BANK----------------");
    }
}
