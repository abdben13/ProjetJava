package test.java.business;

import test.java.model.BankAccount;

@FunctionalInterface
public interface Condition<T> {
    boolean test(T o);

}
