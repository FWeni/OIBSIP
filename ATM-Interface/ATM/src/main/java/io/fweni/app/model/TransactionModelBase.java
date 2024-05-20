package io.fweni.app.model;

import java.util.UUID;

import static com.google.common.base.Preconditions.checkNotNull;

public class TransactionModelBase {
    protected final UUID id;
    protected final Double amount;

    public TransactionModelBase(UUID originalTransaction, Double amount) {
        this.id = checkNotNull(originalTransaction);
        this.amount = amount;
    }

    public UUID getId() {
        return id;
    }
    public Double getAmount() {
        return amount;
    }

}
