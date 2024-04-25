package test.java.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.security.auth.login.AccountNotFoundException;

import test.java.model.AccountStatus;
import test.java.model.BankAccount;
import test.java.model.CurrentAccount;
import test.java.model.SavingAccount;

public class BankAccountServiceImpl implements BankAccountService{
    private List<BankAccount> bankAccountList=new ArrayList<>();

    @Override
    public BankAccount addBankAccount(BankAccount account) {
        bankAccountList.add(account);
        return account;
    }

    @Override
    public void addRandomData(int size) {
        AccountStatus[] values = AccountStatus.values();
        Random random=new Random();
        for(int i = 0; i < size ; i++) {
            BankAccount bankAccount;
            if(Math.random()>0.5){
                //Expression ternaire
                bankAccount=new CurrentAccount(Math.random()>0.5?"MAD":"USD",Math.random()*1000000,Math.random()*50000);
                bankAccount.setStatus(values[random.nextInt(values.length)]);
            }else{
                bankAccount=new SavingAccount(Math.random()>0.5?"MAD":"USD",Math.random()*1000000,3+Math.random()*7);
                bankAccount.setStatus(values[random.nextInt(values.length)]);
            }
            bankAccountList.add(bankAccount);
        }
        
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
    public BankAccount getAccountById(String id) throws AccountNotFoundException {
        //Approche declarative
        return bankAccountList
        .stream()
        .filter(acc->acc.getAccountId().equals(id))
        .findFirst()
        .orElseThrow(()->new AccountNotFoundException("BankAccount not found"));

        //Approche imperative
        /*for(BankAccount bankAccount:bankAccountList){
            if(bankAccount.getAccountId().equals(id)){
                return bankAccount;
            }
        }
        throw new AccountNotFoundException("BankAccount not found");*/
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
