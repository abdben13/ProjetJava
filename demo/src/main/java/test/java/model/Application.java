package test.java.model;

import java.util.List;
import java.util.function.Consumer;

import test.java.business.BankAccountService;
import test.java.business.BankAccountServiceImpl;

public class Application {
    public static void main(String[] args) {
        BankAccountService bankAccountService=new BankAccountServiceImpl();
        bankAccountService.addBankAccount(new CurrentAccount("MAD", 43000, 1000));
        bankAccountService.addBankAccount(new SavingAccount("USD", 12000, 3.5));
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
        allAccounts.forEach(System.out::println);
        /*allAccounts.forEach(account->System.out.println(account.toString()));*/    
    }
}
