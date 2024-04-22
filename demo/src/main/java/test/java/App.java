package test.java;

import test.java.model.BankAccount;

public class App {
    public static void main(String[] args) {
        BankAccount account1=null;
        account1=new BankAccount();
        account1.accountId="123-543";
        account1.currency="MAD";
        account1.balance=7600;

        printAccount(account1);

    }
        public static void printAccount(BankAccount account){
            System.out.println("***********************************************");
            System.out.println("Account ID = "+account.accountId);
            System.out.println("Account Balance = "+account.balance);
            System.out.println("Account Status = "+account.status);
            System.out.println("Account Currency = "+account.currency);
            System.out.println("***********************************************"); 
        }
}