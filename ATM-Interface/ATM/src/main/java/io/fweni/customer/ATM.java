package io.fweni.customer;

import io.fweni.app.model.Deposit;
import io.fweni.app.model.Person;
import io.fweni.app.db.memory.*;
import io.fweni.atm.ATMInterface;

import java.time.LocalDate;

public class ATM implements ATMInterface {
    Double bal = 0.0;
    /**
     * @return the amount of money that is currently in the Customer account
     */
    @Override

    public Double checkBalance() {
        bal = MemoryDb.INSTANCE.getAccountBalance();
        System.out.println(" Your balance is " + bal);
        return bal;
    }

    /**
     * @return the amount of money that was deposited into the customer's account
     */
    @Override
    public Double depositFunds(double depositAmount, Person depositedTo, Person depositedBy) {
        return MemoryDb.
                INSTANCE.
                depositFunds(new Deposit(depositedTo,depositedBy,depositAmount,LocalDate.now()));
    }

    /**
     * @return the amount of money that was taken out the customer's account
     */
    @Override
    public Double withdrawFunds(double withdrawAmount) {
        return 0.0;
    }

    /**
     * @param accountNumber that the money will be sent to
     * @return the amount of money that remains in the account after the transfer
     */
    @Override
    public Double transferFundsTo(String accountNumber, double amount) {
        return 0.0;
    }
}
