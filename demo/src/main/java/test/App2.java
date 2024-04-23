package test;

import test.java.model.BankAccount;

public class App2 {
    public static void main(String[] args) {
        BankAccount [] accounts=new BankAccount[4];
        accounts[0]=new BankAccount();
        accounts[1]=new BankAccount();
        accounts[2]=new BankAccount();
        accounts[3]=new BankAccount();
        for(int i = 0; i <accounts.length; i++) {
            System.out.println(accounts[i]);
        }
    }

}
