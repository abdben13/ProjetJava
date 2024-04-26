package test.java;

import javax.xml.crypto.Data;

import test.java.business.BankAccountService;
import test.java.business.BankAccountServiceImpl;

import java.util.List;

import javax.security.auth.login.AccountNotFoundException;
import test.java.exceptions.BalanceNotFoundSufficientException;
import test.java.model.AccountStatus;
import test.java.model.BankAccount;
import test.java.model.CurrentAccount;
import test.java.model.SavingAccount;
import test.utils.DataTransformationUtils;


public class App3 {
    public static void main(String[] args) throws test.java.exceptions.AccountNotFoundException {
        BankAccountService bankAccountService=new BankAccountServiceImpl();
        bankAccountService.addRandomData(20);
        BankAccount bankAccount1 = new CurrentAccount("MAD", 32000, 100);
        bankAccount1.setAccountId("CC1");
        bankAccountService.addBankAccount(bankAccount1);
        BankAccount bankAccount2 = new SavingAccount("MAD", 1000, 3.2);
        bankAccount2.setAccountId("CC2");
        bankAccountService.addBankAccount(bankAccount2);

        
        /*bankAccountService.getAllAccounts()
        .stream()
        .map(DataTransformationUtils::toJson)
        .forEach(System.out::println);*/

        BankAccount acc1 = null;
        BankAccount acc2 = null;
        try {
            acc1 = bankAccountService.getAccountById("CC1");
            acc2 = bankAccountService.getAccountById("CC2");

            System.out.println(DataTransformationUtils.toJson(acc1));
            System.out.println(DataTransformationUtils.toJson(acc2));

            System.out.println("=================");
            bankAccountService.debit(acc1.getAccountId(), 2000);
            System.out.println(DataTransformationUtils.toJson(acc1));
            System.out.println("=================");
            bankAccountService.transfer(("CC1"), ("CC43"), 3000);
            System.out.println(DataTransformationUtils.toJson(acc1));
            System.out.println(DataTransformationUtils.toJson(acc2));
        } catch (AccountNotFoundException | BalanceNotFoundSufficientException e) {
            System.out.println(e.getMessage());
        } 

        System.out.println("*************");
        System.out.println(DataTransformationUtils.toJson(acc1));
        System.out.println(DataTransformationUtils.toJson(acc2));
        System.out.println("*************");

        System.out.println("++++++++++++++++");
        bankAccountService.getCurrentAccounts()
            .stream()
            .map(DataTransformationUtils::toJson)
            .forEach(System.out::println);

        System.out.println("Total Balance : "+bankAccountService.getTotalBalance());

        List<BankAccount> bankAccountList = bankAccountService.searchAccounts(acc -> (acc.getStatus()==AccountStatus.BLOCKED));
        bankAccountList.stream().map(DataTransformationUtils::toJson).forEach(System.out::println);
    }
}