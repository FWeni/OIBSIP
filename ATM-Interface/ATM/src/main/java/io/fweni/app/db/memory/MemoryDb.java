package io.fweni.app.db.memory;

import com.google.common.collect.ImmutableList;
import io.fweni.app.db.DataRepository;
import io.fweni.app.model.Deposit;
import io.fweni.app.model.Transaction;
import io.fweni.app.model.Person;
import io.fweni.app.model.Withdraw;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public class MemoryDb implements DataRepository {
    private final Set<Person> people = new HashSet<>();
    private final Set<Transaction> expens = new HashSet<>();
    private final Set<Deposit> deposits = new HashSet<>();
    private final Set<Withdraw> withdrawals = new HashSet<>();

    volatile long lastPersonId = 0L;

    public MemoryDb() {
        setTestData();
    }

    /**
     * @param person 
     * @return
     */
    @Override
    public Person addPerson(Person person) {
        return null;
    }

    /**
     * @param person 
     */
    @Override
    public void removePerson(Person person) {

    }

    /**
     * @param person 
     */
    @Override
    public void updatePerson(Person person) {

    }

    /**
     * @param email 
     * @return
     */
    @Override
    public Optional<Person> findPerson(String email) {
        return Optional.empty();
    }

    /**
     * @return 
     */
    @Override
    public ImmutableList<Person> allPersons() {
        return null;
    }

    /**
     * @param deposit 
     * @return
     */
    @Override
    public Deposit depositFunds(Deposit deposit) {
        return null;
    }

    /**
     * @param Id 
     * @return
     */
    @Override
    public Optional<Transaction> findDeposit(UUID Id) {
        return Optional.empty();
    }

    /**
     * @param person 
     * @return
     */
    @Override
    public ImmutableList<Deposit> allDeposits(Person person) {
        return null;
    }

    /**
     * @param withdraw 
     * @return
     */
    @Override
    public Withdraw withdrawFunds(Withdraw withdraw) {
        return null;
    }

    /**
     * @param Id 
     * @return
     */
    @Override
    public Optional<Transaction> findWithdrawal(UUID Id) {
        return Optional.empty();
    }

    /**
     * @param person 
     * @return
     */
    @Override
    public ImmutableList<Withdraw> allWithdrawals(Person person) {
        return null;
    }

    /**
     * @param transaction
     * @return
     */
    @Override
    public Transaction addExpense(Transaction transaction) {
        return null;
    }

    /**
     * @param Id 
     * @return
     */
    @Override
    public Optional<Transaction> findExpense(UUID Id) {
        return Optional.empty();
    }

    /**
     * @param person 
     * @return
     */
    @Override
    public ImmutableList<Transaction> findAllExpenses(Person person) {
        return null;
    }
    private void setTestData() {
    }
}
