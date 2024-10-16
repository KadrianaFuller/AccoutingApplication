package com.Pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner; // imported so I can use my scanner

public class Main {
    //  This line is my Access modifier, Return type , Identifier and the () is for the params
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); // allows users input

        ArrayList<Transactions> transactions= new ArrayList<>(); // called in the main class, so I can use it in the method. This will allow me to store transactions.

        int options; // used to define my options to store user's selection
        while (true){ // Created while loop so home screen can continue until you exit.
            System.out.print("""
                    What do you want to do?
                    1. Add Deposit
                    2. Make a Payment
                    3. Display Ledger
                    4. Exit
                    Please select an option:""");
            options = in.nextInt();

            switch (options){
                case 1:
                    addDeposit(in);
                    break;
                case 2:
                    makePayment(in);
                    break;
                case 3:
                    displayLedger();
                    break;
                case 4:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Invalid Option. Please Try again.");
            }
        }


    }
    // Add deposit method to be used when user press 1. Which was initialized in the main.
    public static void addDeposit(Scanner in) {
        System.out.print("Enter Date (YYY-MM-DD): ");
        String date = in.next();
        System.out.print("Enter Time (HH:MM:SS): ");
        String time = in.next();
        System.out.print("Enter Description: ");
        String description = in.next();
        System.out.print("Enter Vendor: ");
        String vendor = in.next();
        System.out.print("Enter Amount: ");
        Double amount = in.nextDouble();

      // Transactions object that will allow me to use transactions class
        Transactions actions = new Transactions(date,time,description,vendor,amount);
        actions.add(actions);
        try {
            saveTransaction(actions);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Deposit Successful");

    }

    // Method that will allow me to save my entries to my csv
    public static void saveTransaction(Transactions transaction) throws IOException {
        // writing to file
        try (FileWriter fileWriter = new FileWriter("transactions.csv", true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write(transaction.toString());

            bufferedWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void displayLedger() {
    }

    public static void makePayment(Scanner in) {
        System.out.print("Enter Date (YYY-MM-DD): ");
        String date = in.next();
        System.out.print("Enter Time (HH:MM:SS): ");
        String time = in.next();
        System.out.print("Enter Description: ");
        String description = in.next();
        System.out.print("Enter Vendor: ");
        String vendor = in.next();
        System.out.print("Enter Amount: ");
        Double amount = in.nextDouble();

        Transactions actions = new Transactions(date,time,description,vendor,amount);
        actions.add(actions);
        try {
            saveTransaction(actions);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Payment Successful");

    }






    }

