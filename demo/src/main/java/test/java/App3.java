package test.java;

import javax.xml.crypto.Data;

import test.java.business.BankAccountService;
import test.java.business.BankAccountServiceImpl;
import test.utils.DataTransformationUtils;

public class App3 {
    public static void main(String[] args) {
        BankAccountService bankAccountService=new BankAccountServiceImpl();
        bankAccountService.addRandomData(20);
        bankAccountService.getAllAccounts()
        .stream()
        .map(DataTransformationUtils::toJson)
        .forEach(System.out::println);
    }
}
