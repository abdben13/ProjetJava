package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import test.java.model.BankAccount;
import test.java.model.CurrentAccount;
import test.java.model.SavingAccount;

public class App2 {
    public static void main(String[] args) throws JsonProcessingException {
        
        BankAccount [] accounts=new BankAccount[4];
        accounts[0]=new CurrentAccount("USD", 5400, 500);
        accounts[1]=new CurrentAccount("MAD", 1290, 4300);
        accounts[2]=new SavingAccount("USD", 3200, 4.6);
        accounts[3]=new SavingAccount("MAD", 5400, 4.3);
        
        for(BankAccount acc:accounts) {
            System.out.println(acc.getType()); /*polymorphisme */
        }

        List<BankAccount> bankAccountList=new ArrayList<>();
        bankAccountList.add(new CurrentAccount("MAD", 5000, 200));
        bankAccountList.add(new SavingAccount("USD", 3000, 4.6));
        
        System.out.println("List:");
        for(BankAccount acc:accounts) {
            System.out.println(acc.getBalance());
        }

        

        System.out.println("=====================Map=========");
        Map<String, BankAccount> BankAccountMap=new HashMap<>();
        BankAccountMap.put("cc1", new CurrentAccount());
        BankAccountMap.put("cc2", new CurrentAccount());
        BankAccountMap.put("cc3", new SavingAccount());
        
        BankAccount acc=BankAccountMap.get("cc1");
        System.out.println(acc.toString());

        for(String key:BankAccountMap.keySet()) {
            System.out.println(BankAccountMap.get(key));
        }

        System.out.println("=========================");
        for(BankAccount ba:BankAccountMap.values()){
        System.out.println(toJson(ba));
        }
    }
    
    public static String toJson(Object o) throws JsonProcessingException{
        ObjectMapper objectMapper=new ObjectMapper();
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(o);
    }
}
