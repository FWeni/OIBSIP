package io.fweni;

import io.fweni.app.model.Person;
import io.fweni.controller.Person.PersonController;
import io.fweni.customer.ATM;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Please enter your email to login :");
        Scanner input = new Scanner(System.in);

        PersonController personController = new PersonController();
        ATM atm = new ATM();


        while (input.hasNext()) {
            List<Person> bankers = personController.getAllBankers();
            System.out.println(bankers);
            Person banker = new Person(input.next());

             if (bankers.contains(banker)) {
                 personController.getBanker(banker);
                 System.out.println("Welcome "+banker.getName()+" :)");

                 System.out.println("Here are your options :");
                 System.out.println("Check balance ?");
                 if (input.next().equalsIgnoreCase("check balance")) {
                     atm.checkBalance();
                 }
             } else {
                 System.out.println("We were unable to locate your account.");
                 System.out.println("Would you like to join our bank?");
                 if (input.hasNext()) {
                     if (input.next().equalsIgnoreCase("yes")) {
                         System.out.println("Please enter your email again :");
                         personController.addNewBanker(banker);
                         System.out.println("Welcome "+banker.getName());

                     }
                 }
             }
        }


    }
}