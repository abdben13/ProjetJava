package test.java;

import test.java.model.BankAccount;
import test.java.model.CurrentAccount;
import test.java.model.SavingAccount;

public class App {
    public static void main(String[] args) {
        
        BankAccount account1=null;
        account1=new CurrentAccount();
        account1.setCurrency("MAD");
        account1.setBalance(7600);
        account1.setName("Abdel");

        BankAccount account2=new CurrentAccount("MAD", 1200, 400);
        BankAccount account3=new SavingAccount("MAD", 1200, 3.4);

        printAccount(account1);
        printAccount(account2);
        printAccount(account3);

    }
    public static void printAccount(BankAccount account) {
        System.out.println("***********************************************");
        System.out.println("Account Name = " + account.getName());
        System.out.println("Account ID = " + account.getAccountId());
        System.out.println("Account Balance = " + account.getBalance());
        System.out.println("Account Status = " + account.getStatus());
        System.out.println("Account Currency = " + account.getCurrency());
        
        if (account instanceof CurrentAccount) {
            CurrentAccount currentAccount = (CurrentAccount) account;
            System.out.println("Account OverDraft = " + currentAccount.getOverDraft());
        }else {
            SavingAccount  savingAccount = (SavingAccount) account;
            System.out.println("Account Interest Rate = " + savingAccount.getInterestRate());
        }
        
        System.out.println(account.toString());
        System.out.println("***********************************************");
    }
    
}