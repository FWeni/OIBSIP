package io.fweni.app.db.memory;

import com.google.common.collect.ImmutableList;
import io.fweni.app.db.DataRepository;
import io.fweni.app.model.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public class MemoryDb implements DataRepository {
    private final Set<Person> people = new HashSet<>();
    private final Set<Expense> expenses = new HashSet<>();
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
        Optional<Person> alreadyExists =
                findPerson(person.getEmail());
        if (alreadyExists.isPresent()) {
            return alreadyExists.get();
        }
        person.setId(nextPersonId());
        people.add(person);
        return person;
    }

    private Long nextPersonId() {
        synchronized (this) {
            return ++lastPersonId;
        }
    }

    /**
     * @param person 
     */
    @Override
    public void removePerson(Person person) {
        people.remove(person);
    }

    /**
     * @param updatedPerson
     */
    @Override
    public void updatePerson(Person updatedPerson) {
        Optional<Person> PersonOpt =
                people.stream()
                        .filter(Person -> Person.getEmail().
                                equalsIgnoreCase(updatedPerson.getEmail()))
                        .findFirst();
        if (PersonOpt.isPresent()) {
            people.remove(PersonOpt.get());
            people.add(updatedPerson);
        }

    }

    /**
     * @param email 
     * @return
     */
    @Override
    public Optional<Person> findPerson(String email) {
        return people
                .stream()
                .filter(Person -> Person.getEmail()
                        .equalsIgnoreCase(email))
                .findFirst();
    }

    /**
     * @return 
     */
    @Override
    public ImmutableList<Person> allPersons() {
        return ImmutableList.copyOf(people);
    }

//    /**
//     * @param deposit
//     * @return
//     */
//    @Override
//    public Deposit depositFunds(Deposit deposit) {
//        deposits.add(deposit);
//        return deposit;
//    }
//
//    /**
//     * @param Id
//     * @return
//     */
//    @Override
//    public Optional<Deposit> findDeposit(UUID Id) {
//        return deposits
//                .stream()
//                .filter(Deposit -> Deposit.getId()
//                        .equals(Id)).findFirst();
//    }
//
//    /**
//     * @param person
//     * @return
//     */
//    @Override
//    public ImmutableList<Deposit> allDeposits(Person person) {
//        return ImmutableList.copyOf(deposits);
//    }
//
//    /**
//     * @param withdraw
//     * @return
//     */
//    @Override
//    public Withdraw withdrawFunds(Withdraw withdraw) {
//        return null;
//    }
//
//    /**
//     * @param Id
//     * @return
//     */
//    @Override
//    public Optional<Withdraw> findWithdrawal(UUID Id) {
//        return Optional.empty();
//    }
//
//    /**
//     * @param person
//     * @return
//     */
//    @Override
//    public ImmutableList<Withdraw> allWithdrawals(Person person) {
//        return ImmutableList.copyOf(withdrawals);
//    }
//
//    /**
//     * @param Expense
//     * @return
//     */
//    @Override
//    public Expense addExpense(Expense Expense) {
//        return null;
//    }
//
//    /**
//     * @param Id
//     * @return
//     */
//    @Override
//    public Optional<Expense> findExpense(UUID Id) {
//        return Optional.empty();
//    }
//
//    /**
//     * @param person
//     * @return
//     */
//    @Override
//    public ImmutableList<Expense> findAllExpenses(Person person) {
//        return ImmutableList.copyOf(expenses);
//    }
    private void setTestData() {
        Person Refilwe = new Person("refilwe@testing.co.za");
        Person Thabo = new Person("thabo@testing.com");


    }
}
