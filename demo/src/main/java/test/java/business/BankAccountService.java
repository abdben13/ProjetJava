package test.java.business;

import java.util.List;
import test.java.exceptions.AccountNotFoundException;
import test.java.exceptions.BalanceNotFoundSufficientException;
import test.java.model.BankAccount;

public interface BankAccountService {
    BankAccount addBankAccount(BankAccount account);
    List<BankAccount> getAllAccounts();
    BankAccount getAccountById(String id) throws AccountNotFoundException, javax.security.auth.login.AccountNotFoundException;
    void addRandomData(int size);
    void credit(String accountId, double amount) throws AccountNotFoundException, javax.security.auth.login.AccountNotFoundException;
    void debit(String accountId, double amount) throws AccountNotFoundException, BalanceNotFoundSufficientException, javax.security.auth.login.AccountNotFoundException;
    void transfer(String accountId, String accountDestination, double amount) throws AccountNotFoundException, BalanceNotFoundSufficientException, javax.security.auth.login.AccountNotFoundException;
    List<BankAccount> getSavingAccounts();
    List<BankAccount> getCurrentAccounts();
    double getTotalBalance();
    List<BankAccount> searchAccounts(Condition<BankAccount> condition);
}
