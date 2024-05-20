package io.fweni.app.model;

import java.time.LocalDate;

public class Deposit {
    private final Transaction transact;
    private final Person person;
    private final BusinessEntity businessEntity;
    private final Double amount;
    private final LocalDate date;

    public Deposit(
            Transaction transaction,
            Person depositedBy,
            BusinessEntity depositedAt,
            Double depositedAmount,
            LocalDate depositedDate) {
        this.transact = transaction;
        this.person = depositedBy;
        this.businessEntity = depositedAt;
        this.amount = depositedAmount;
        this.date = depositedDate;
    }

    public boolean isDeposited() {
        return false;
    }

    public Double getAmount() {
        return amount;
    }

    public Transaction getTransact() {
        return transact;
    }

    public Person getPerson() {
        return person;
    }

    public BusinessEntity getBusinessEntity() {
        return businessEntity;
    }

    public LocalDate getDepositDate() {
        return date;
    }
}
