package io.fweni.app.model;

import java.time.LocalDate;

public class Expense {
    private final Transaction transact;
    private final BusinessEntity businessEntity;
    private final Double amount;
    private final LocalDate date;

    public Expense(
            Transaction transaction,
            BusinessEntity spentAmountAt,
            Double amountSpent,
            LocalDate expenseDate) {
        this.transact = transaction;
        this.businessEntity = spentAmountAt;
        this.amount = amountSpent;
        this.date = expenseDate;
    }

    public boolean isExpense() {
        return true;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getExpenseDate() {
        return date;
    }
}
