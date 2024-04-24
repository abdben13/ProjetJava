package test.java.business;

import java.util.ArrayList;
import java.util.List;

import test.java.model.BankAccount;

public class BankAccountServiceImpl implements BankAccountService{
    private List<BankAccount> bankAccountList=new ArrayList<>();

    @Override
    public BankAccount addBankAccount(BankAccount account) {
        bankAccountList.add(account);
        return account;
    }

    @Override
    public void addRandomData(int size) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void credit(String accountId, double amount) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void debit(String accountId, double amount) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public BankAccount getAccountById(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<BankAccount> getAllAccount() {
        return bankAccountList;
    }

    @Override
    public void transfer(String accountId, String accountDestination, double amount) {
        // TODO Auto-generated method stub
        
    }
    
}
