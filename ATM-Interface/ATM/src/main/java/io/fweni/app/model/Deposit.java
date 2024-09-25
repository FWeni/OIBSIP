package io.fweni.app.model;

import java.time.LocalDate;
import java.util.UUID;

public class Deposit extends TransactionModelBase {
    private final Person accHolder;
    private final Person depositor;
//    private final BusinessEntity businessEntity;
    private final Double amount;
    private final LocalDate date;

    public Deposit(
            Person depositTo,
            Person depositedBy,
            Double depositedAmount,
            LocalDate depositedDate) {
        super(UUID.randomUUID(), depositedAmount);
        this.accHolder = depositTo;
        this.depositor = depositedBy;
//        this.businessEntity = depositedAt;
        this.amount = depositedAmount;
        this.date = depositedDate;
    }

    public boolean isDeposited() {
        return false;
    }

    public Double getAmount() {
        return amount;
    }

//    public Transaction getTransact() {
//        return transact;
//    }

    public Person getDepositor() {
        return depositor;
    }

//    public BusinessEntity getBusinessEntity() {
//        return businessEntity;
//    }

    public LocalDate getDepositDate() {
        return date;
    }
}
