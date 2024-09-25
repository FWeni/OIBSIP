package io.fweni.atm;

import io.fweni.app.model.Person;

public interface ATMInterface {

    /**
     * @return amount that is available in the user's account
     */
    Double checkBalance();

    /**
     * @return updated amount after deposited funds have been added to user's account
     */
    Double depositFunds(double deposit, Person depositedTo, Person depositedBy);

    /**
     * @return updated amount after withdrawn funds have been deducted from user's account
     */
    Double withdrawFunds(double withdraw);

    /**
     * @return updated amount after the transferred funds have been deducted from user's account
     */
    Double transferFundsTo(String accountNumber, double amount);
//    Double transferFunds(String accountNumber);
}
