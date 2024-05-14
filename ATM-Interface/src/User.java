
import java.io.*;
import java.util.*;

import org.json.simple.*;
import org.json.simple.parser.*;

public class User {
    private String loginId;
    private String loginPin;

    public User() {}

    public User(String userId, String userPin) {
        this.loginId = userId;
        this.loginPin = userPin;
    }

    private void userLogin() {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Please enter your login ID :");
        String userIdInput = scanner.next();
        System.out.println("Please enter your pin :");
        String userPinInput = scanner.next();

//        if() {}
    }
    private List<String> getTransactionsHistory() {
        // time stamp will be needed
        // description of the transaction
        // amount spent
        // amount remaining
        return null;
    }
    private int withdraw(int withdrawalAmount, int accountBalance) {
        // time stamp
        // subtract w/a from bal
        return 0;
    }

    private int deposit(int depositAmount) {
        //time stamp
        // add d/a to bal
        return 0;
    }

    private int transfer(int transferAmount) {
        // time stamp
        // subtract t/a from bal
        return 0;
    }

}
