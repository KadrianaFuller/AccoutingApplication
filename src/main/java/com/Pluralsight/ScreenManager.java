package com.Pluralsight;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class ScreenManager {

    ArrayList<Transactions> transactions = new ArrayList<>();
   public static Scanner in = new Scanner(System.in);

    public static void homeScreen(){
        int options; // used to define my options to store user's selection
        while (true){ // Created while loop so home screen can continue until you exit.
            System.out.print("""
                    What do you want to do?
                    1. Add Deposit
                    2. Make a Payment
                    3. Display Ledger
                    4. Exit
                    Please select an option:""");

            // options = in.nextInt();
            options = Integer.parseInt(in.nextLine().trim()); // used to make sure an extra line never comes up

            switch (options){ // handles user chose and calls the different method
                case 1:
                    addDeposit(in);
                    break;
                case 2:
                    makePayment(in);
                    break;
                case 3:
                    displayLedger(in);
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Option. Please Try again.");
            }
        }


    }
    // Add deposit method to be used when user press 1. Which was initialized in the main.
    public static void addDeposit(Scanner in) {
        LocalDateTime now = LocalDateTime.now(); // gets current date and time
        System.out.print("Enter Description: ");
        String description = in.nextLine();
        System.out.print("Enter Vendor: ");
        String vendor = in.nextLine();
        System.out.print("Enter Amount: ");
        Double amount = in.nextDouble();

        // Transactions object that will allow me to use transactions class
        // used DateTimeFormatter to format how I wanted my date and time to come out
        Transactions actions = new Transactions(now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), now.format(DateTimeFormatter.ofPattern("HH:mm:ss")), description,vendor,amount);
        actions.add(actions);// adds to transactions list
        LedgerDAO.addToDatabase(actions);
        try {
            saveTransaction(actions); // saves the transaction.
        } catch (IOException e) {
            System.out.println(" Error processing. Please try again");

        }
        System.out.println("Deposit Successful");

        in.nextLine();

    }

    // Method that will allow me to save my entries to my csv
    // try with resources() is used to automatically close the resource even if an exception occured.
    // Different from Try {} because this option you have to manually close by including a buffered.close
    public static void saveTransaction(Transactions transaction) throws IOException {
        // writing to file
        try (FileWriter fileWriter = new FileWriter("src/main/resources/transactions.csv", true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write(transaction.toString()); // calling to the toString for format
            bufferedWriter.newLine();
            LedgerDAO.addToDatabase(transaction);
        } catch (IOException e) {
            System.out.println("Error saving. Try again.");
        }
    }


    public static void displayLedger(Scanner in) {
        System.out.print("""
                Ledger Home Screen
                What would you like to do:
                (A) Display all Entries
                (D) Display Deposits
                (P) Display Payments
                (R) Display Reports
                (H) Go Home
                Please select an option:""");

        in.nextLine();

        String choice;
        choice = in.nextLine().toUpperCase();
        switch (choice){
            case "A":
            case "a":
                displayAll(in);
                break;
            case "D":
            case "d":
                displayDeposit();
                break;
            case "P":
            case "p":
                displayPayments();
                break;
            case "R":
            case "r":
                displayReports();
                break;

            case "H":
            case "h":
                goHome();
                break;
            default:
                System.out.println("Invalid choice. Try Again.");
                displayLedger(in); // if they choose the wrong letter this will allow the prompt to start over

                in.nextLine();
        }



    }

    private static void goHome() {
        System.out.println("Returning to Home Screen....");
        homeScreen();
    }

    private static void displayReports() {
        int option;
        while (true){
            System.out.print("""
                
                Reports Menu:
                1. Month to Date
                2. Previous Month
                3. Year to Date
                4. Previous Year
                5. Search by Vendor
                0. Back
                Please select an option: """);

            option = Integer.parseInt(in.nextLine());
            switch (option) {
                case 1:
                    runMonthToDateReport();
                    break;
                case 2:
                    runPreviousMonthReport();
                    break;
                case 3:
                    runYearToDateReport();
                    break;
                case 4:
                    runPreviousYearReport();
                    break;
                case 5:
                    searchByVendor();
                    break;
                case 0:
                    goHome();
                    return; // Exit the method
                default:
                    System.out.println("Invalid option. Please try again.");
            }

        }

    }

    private static void searchByVendor() {
    }

    private static void runPreviousYearReport() {
    }

    private static void runYearToDateReport() {
    }

    private static void runPreviousMonthReport() {
    }

    private static void runMonthToDateReport() {
    }

    private static void displayPayments() {


    }

    private static void displayDeposit() {
    }

    private static void displayAll(Scanner in) {



    }


    public static void makePayment(Scanner in) {
        LocalDateTime now = LocalDateTime.now(); // used this so that the date and time autopopulated
        System.out.print("Enter Description: ");
        String description = in.nextLine();
        System.out.print("Enter Vendor: ");
        String vendor = in.nextLine();
        System.out.print("Enter Amount: ");
        Double amount = in.nextDouble();

        Transactions actions = new Transactions(now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), now.format(DateTimeFormatter.ofPattern("HH:mm:ss")), description, vendor, amount);
        actions.add(actions);
        try {
            saveTransaction(actions);
        } catch (IOException e) {
            System.out.println(" Error processing. Please try again");
        }
        System.out.println("Payment Successful");
        in.nextLine();

    }






}













