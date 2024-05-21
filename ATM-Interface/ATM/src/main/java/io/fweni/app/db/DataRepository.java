package io.fweni.app.db;

import com.google.common.collect.ImmutableList;
import io.fweni.app.db.memory.MemoryDb;
import io.fweni.app.model.*;

import java.util.*;

public interface DataRepository {
    static DataRepository INSTANCE = new MemoryDb();

    static DataRepository getInstance() {
        return INSTANCE;
    }

    Person addPerson(Person person);
    void removePerson(Person person);
    void updatePerson(Person person);
    Optional<Person> findPerson( String email);
    ImmutableList<Person> allPersons();

//    Deposit depositFunds(Deposit deposit);
//    Optional<Deposit> findDeposit(UUID Id);
//    ImmutableList<Deposit> allDeposits(Person person);
//
//    Withdraw withdrawFunds(Withdraw withdraw);
//    Optional<Withdraw> findWithdrawal(UUID Id);
//    ImmutableList<Withdraw> allWithdrawals(Person person);
//
//    Expense addExpense(Expense expense);
//    Optional<Expense> findExpense(UUID Id);
//    ImmutableList<Expense> findAllExpenses(Person person);

}
