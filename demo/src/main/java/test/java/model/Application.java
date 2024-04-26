package test.java.model;

import java.util.List;
import java.util.function.Consumer;

import test.java.exceptions.AccountNotFoundException;

import test.java.business.BankAccountService;
import test.java.business.BankAccountServiceImpl;

public class Application {
    public static void main(String[] args) throws javax.security.auth.login.AccountNotFoundException {
        BankAccountService bankAccountService=new BankAccountServiceImpl();
        bankAccountService.addBankAccount(new CurrentAccount("MAD", 43000, 1000));
        bankAccountService.addBankAccount(new SavingAccount("USD", 12000, 3.5));
        BankAccount bankAccount3=new CurrentAccount("MAD", 43000, 100);
        bankAccount3.setAccountId("CC1");
        bankAccountService.addBankAccount(bankAccount3);
        List<BankAccount> allAccounts = bankAccountService.getAllAccounts();

        /*Plusieurs sortes de boucles possibles : 
        /*for(int i = 0; i<allAccounts.size(); i++) {
            System.out.println("*******************************************************");
            System.out.println(allAccounts.get(i).toString());
        }*/
        /*for(BankAccount bankAccount:allAccounts) {
            System.out.println("*******************************************************");
            System.out.println(bankAccount.toString());
        }*/
        System.out.println("*******************************************************");
        allAccounts.forEach(System.out::println);
        /*allAccounts.forEach(account->System.out.println(account.toString()));*/
        System.out.println("*******************************************************");

        BankAccount accountById = null;
        try{
            accountById = bankAccountService.getAccountById("CC1");
            System.out.println(accountById.toString());
        }catch (AccountNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        System.out.println("==========================");
        System.out.println("Suite du programme");
    }
}
