package io.fweni.customer;

import io.fweni.atm.ATM;

public class CustomerAccount implements ATM {
    /**
     * @return 
     */
    @Override
    public Double checkBalance() {
        return 0.0;
    }

    /**
     * @return 
     */
    @Override
    public Double depositFunds() {
        return 0.0;
    }

    /**
     * @return 
     */
    @Override
    public Double withdrawFunds() {
        return 0.0;
    }

    /**
     * @param accountNumber 
     * @return
     */
    @Override
    public Double transferFundsTo(String accountNumber) {
        return 0.0;
    }
}
