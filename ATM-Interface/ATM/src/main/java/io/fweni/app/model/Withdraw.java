package io.fweni.app.model;

import java.time.LocalDate;

public class Withdraw {
    private final Transaction transaction;
    private final BusinessEntity withdrawalFrom;
    private final Double amount;
    private final LocalDate withdrawalDate;

    public Withdraw(
            Transaction transaction,
            BusinessEntity withdrawalFrom,
            Double amount,
            LocalDate withdrawalDate
    ) {
        this.transaction = transaction;
        this.withdrawalFrom = withdrawalFrom;
        this.amount = amount;
        this.withdrawalDate = withdrawalDate;
    }

    public LocalDate getWithdrawalDate() {
    }

    public boolean isWithdrawn() {
        return false;
    }

    public Double getAmount() {
        return amount;
    }

//    public Withdraw(BusinessEntity businessLocation,  LocalDate date) {}/
}
