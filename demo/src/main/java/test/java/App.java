package test.java;

import test.java.model.BankAccount;

public class App {
    public static void main(String[] args) {
        BankAccount account1=null;
        account1=new BankAccount();
        /**account1.setAccountId("123-543");**/
        account1.setCurrency("MAD");
        account1.setBalance(7600);
        account1.setName("Abdel");

        printAccount(account1);

    }
        public static void printAccount(BankAccount account){
            System.out.println("***********************************************");
            System.out.println("Account Name = "+account.getName());
            System.out.println("Account ID = "+account.getAccountId());
            System.out.println("Account Balance = "+account.getBalance());
            System.out.println("Account Status = "+account.getStatus());
            System.out.println("Account Currency = "+account.getCurrency());
            System.out.println(account.toString());
            System.out.println("***********************************************"); 
        }
}