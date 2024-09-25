package io.fweni.app.model;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Transaction extends TransactionModelBase {

    private final LocalDate date;
    private final String description;
    private final BusinessEntity  business;
    private final Set<Withdraw> withdrawals;
    private final Set<Deposit> deposits;
//    private final Set<Transfer> transfers;
    private final Set<Expense> expenses;

    public Transaction(
            Double amount,
            LocalDate date,
            String description,
            BusinessEntity business
    ) {
        super(UUID.randomUUID(), amount);
        this.date = date;
        this.description = description;
        this.business = business;
        this.withdrawals = new HashSet<>();
        this.deposits = new HashSet<>();
//        this.transfers = new HashSet<>();
        this.expenses = new HashSet<>();
    }
    public Withdraw createWithdrawal(
//            BusinessEntity withdrawalFrom,
            Double amount,
            LocalDate withdrawalDate
    ) {
        Double currentAmountWithdrawn =
                this.withdrawals.stream()
                        .mapToDouble(Withdraw::getAmount).sum();
        if(currentAmountWithdrawn > this.getAmount()) {
            throw new RuntimeException("Insufficient funds.");
        }
        Withdraw withdraw =
                new Withdraw(
//                        this,
//                        withdrawalFrom,
                        amount,
                        withdrawalDate
                );
        this.withdrawals.add(withdraw);
        return withdraw;
    }
    public Set<Withdraw> getWithdrawals() {
        return withdrawals
                .stream()
                .sorted(Comparator.comparing(Withdraw::getWithdrawalDate))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
    public Deposit createDeposit(
            Person depositedTo,
            Person depositedBy,
            Double depositedAmount,
            LocalDate depositedDate
    ) {
        Double currentAmountDeposited =
                this.deposits.stream()
                        .mapToDouble(Deposit::getAmount).sum();
        if(currentAmountDeposited > this.getAmount()) {
            throw new RuntimeException("Insufficient funds.");
        }
        Deposit deposit =
                new Deposit(
//                        this,
                        depositedTo,
                        depositedBy,
//                        depositedAt,
                        depositedAmount,
                        depositedDate
                );
        this.deposits.add(deposit);
        return deposit;
    }
    public Set<Deposit> getDeposits() {
        return deposits
                .stream()
                .sorted(Comparator.comparing(Deposit::getDepositDate))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
    public Expense createExpense(
            BusinessEntity spentAmountAt,
            Double amountSpent,
            LocalDate expenseDate
    ) {
        Double currentExpenseAmount =
                this.expenses.stream()
                        .mapToDouble(Expense::getAmount).sum();
        if(currentExpenseAmount > this.getAmount()) {
            throw new RuntimeException("Insufficient funds.");
        }
        Expense expense =
                new Expense(
                        this,
                        spentAmountAt,
                        amountSpent,
                        expenseDate
                );
        this.expenses.add(expense);
        return expense;
    }
    public Set<Expense> getExpenses() {
        return expenses
                .stream()
                .sorted(Comparator.comparing(Expense::getExpenseDate))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
    public LocalDate getDate() {return date;}

    public String getDescription() {
        return description;
    }

    public BusinessEntity getBusiness() {
        return business;
    }
    @Override
    public boolean equals(Object object) {
        if(this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Transaction transaction = (Transaction) object;

        if (!date.equals(transaction.date)) return false;
        if (!description.equals(transaction.description)) return false;
        return business.equals(transaction.business);

    }
    @Override
    public int hashCode() {
        int result = date.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + business.hashCode();
        return result;
    }
    @Override
    public String toString() {
        return "Transaction {"+
                "date="+date+
                ", description="+description+'\''+
                ", business="+business+
                ", amount="+amount+
                '}';
    }
    public String getFormattedAmount() {
        return String.format("R %,2f",this.amount);
    }
    public Double getTotalWithdrawals() {
        if (withdrawals.isEmpty()) return 0.0;
        return withdrawals.stream()
                .map(Withdraw::getAmount)
                .reduce(Double::sum).get();
    }
    public Double getTotalDeposits() {
        if (deposits.isEmpty()) return 0.0;
        return deposits.stream()
                .map(Deposit::getAmount)
                .reduce(Double::sum).get();
    }
    public Double getTotalExpenses() {
        if (expenses.isEmpty()) return 0.0;
        return expenses.stream()
                .map(Expense::getAmount)
                .reduce(Double::sum).get();
    }
    public Double getNettAmount() {
        double balance = 0.0;
        if(getTotalWithdrawals() > 0.0) {balance = (this.amount - getTotalWithdrawals());}
        if(getTotalDeposits() > 0.0) {balance = (this.amount + getTotalDeposits());}
        if(getTotalExpenses() > 0.0) {balance = (this.amount - getTotalExpenses());}
        return balance;
    }

//    private Double getTotalTransactions() {
//        if (withdrawals.isEmpty()) return 0.0;
//        if (deposits.isEmpty()) return 0.0;
////        if (transfers.isEmpty()) return 0.0;
//        if (expenses.isEmpty()) return 0.0;
//        Double totalWithdrawals =
//                withdrawals.stream()
//                        .filter(Withdraw::isWithdrawn)
//                        .mapToDouble(Withdraw::getAmount)
//                        .sum();
//        Double totalDeposits =
//                deposits.stream()
//                        .filter(Deposit::isDeposited)
//                        .mapToDouble(Deposit::getAmount)
//                        .sum();
//        Double totalExpenses =
//                expenses.stream()
//                        .filter(Expense::isExpense)
//                        .mapToDouble(Expense::getAmount)
//                        .sum();
//        return (amount + totalDeposits) - (totalExpenses + totalWithdrawals);
//    }
}
