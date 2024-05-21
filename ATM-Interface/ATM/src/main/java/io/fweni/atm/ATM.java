package io.fweni.atm;

public interface ATM {

    /**
     * @return amount that is available in the user's account
     */
    Double checkBalance();

    /**
     * @return updated amount after deposited funds have been added to user's account
     */
    Double depositFunds();

    /**
     * @return updated amount after withdrawn funds have been deducted from user's account
     */
    Double withdrawFunds();

    /**
     * @return updated amount after the transferred funds have been deducted from user's account
     */
    Double transferFundsTo(String accountNumber);
//    Double transferFunds(String accountNumber);
}
