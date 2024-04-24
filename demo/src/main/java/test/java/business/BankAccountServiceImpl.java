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
        for(BankAccount bankAccount:bankAccountList){
            if(bankAccount.getAccountId().equals(id)){
                return bankAccount;
            }
        }
        throw new RuntimeException("BankAccount not found");
    }

    @Override
    public List<BankAccount> getAllAccounts() {
        return bankAccountList;
    }

    @Override
    public void transfer(String accountId, String accountDestination, double amount) {
        // TODO Auto-generated method stub
        
    }
    
}
