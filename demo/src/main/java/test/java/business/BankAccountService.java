package test.java.business;

import java.util.List;

import test.java.model.BankAccount;

public interface BankAccountService {
    BankAccount addBankAccount(BankAccount account);
    List<BankAccount> getAllAccounts();
    BankAccount getAccountById(String id);
    void addRandomData(int size);
    void credit(String accountId, double amount);
    void debit(String accountId, double amount);
    void transfer(String accountId, String accountDestination, double amount);
}
