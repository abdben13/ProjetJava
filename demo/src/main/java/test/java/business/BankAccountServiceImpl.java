package test.java.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.security.auth.login.AccountNotFoundException;

import test.java.exceptions.BalanceNotFoundSufficientException;
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
    public void credit(String accountId, double amount) throws AccountNotFoundException {
        BankAccount accountById = getAccountById(accountId);
        accountById.setBalance(accountById.getBalance()+amount);
    }

    @Override
    public void debit(String accountId, double amount) throws AccountNotFoundException, BalanceNotFoundSufficientException {
        BankAccount accountById = getAccountById(accountId);
        if(amount>accountById.getBalance()) throw new BalanceNotFoundSufficientException("Balance not sufficient");
        accountById.setBalance(accountById.getBalance()-amount);
    }

    @Override
    public BankAccount getAccountById(String id) throws AccountNotFoundException {
        //Approche declarative
        return bankAccountList
        .stream()
        .filter(acc->acc.getAccountId().equals(id))
        .findFirst()
        .orElseThrow(()->new AccountNotFoundException(String.format("BankAccount %s not found", id)));
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
    public void transfer(String accountSource, String accountDestination, double amount) throws AccountNotFoundException, BalanceNotFoundSufficientException {
        debit(accountSource, amount);
        credit(accountDestination, amount);
    }

    @Override
    public List<BankAccount> getSavingAccounts() {
        //Declarative approche
        List<BankAccount> collect = bankAccountList
        .stream()
        .filter(acc->acc instanceof SavingAccount)
        .collect(Collectors.toList());
        return collect;

        //Imperative approche
        /*List<BankAccount> result=new ArrayList<>();
        for(BankAccount acc:bankAccountList){
            if(acc.getType().equals("SAVING_ACCOUNT")){
                result.add(acc);
            }
        }
        return result;*/
    }

    @Override
    public List<BankAccount> getCurrentAccounts() {
        List<BankAccount> collect = bankAccountList
        .stream()
        .filter(acc->acc instanceof CurrentAccount)
        .collect(Collectors.toList());
        return collect;
    }

    @Override
    public double getTotalBalance() {
        return bankAccountList
        .stream()
        .map(account -> account.getBalance())
        .reduce(0.0, (a,v)->a+v);

        //Imperative approche
        /*double sum=0;
        for(BankAccount acc:bankAccountList){
            sum=sum+acc.getBalance();
        }
        return sum;*/
    }

    @Override
    public List<BankAccount> searchAccounts(Condition condition) {
       List<BankAccount> result = new ArrayList<>();
       for(BankAccount acc:bankAccountList){
           if(condition.test(acc)){
               result.add(acc);
           }
       }
    return result;
    }

    
    
}
