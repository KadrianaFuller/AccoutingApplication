package com.Pluralsight;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class ScreenManager {

   public static ArrayList<Transactions> transactions = new ArrayList<>();
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
            options = Integer.parseInt(in.nextLine()); // used to make sure an extra line never comes up

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
        String description = in.next();
        System.out.print("Enter Vendor: ");
        String vendor = in.next();
        System.out.print("Enter Amount: ");
        Double amount = in.nextDouble();

        // Transactions object that will allow me to use transactions class
        // used DateTimeFormatter to format how I wanted my date and time to come out
        Transactions actions = new Transactions(now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), now.format(DateTimeFormatter.ofPattern("HH:mm:ss")), description,vendor,amount);
        actions.add(actions); // adds to transactions list
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
        System.out.print("\nEnter Vendor Name: ");
        String vendor = in.nextLine();

        System.out.println("\nSearch Results for Vendor: " + vendor + "\n");

        transactions.stream()
                .filter(t -> t.getVendor().equalsIgnoreCase(vendor))
                .forEach(System.out::println);

        if (transactions.stream().noneMatch(t -> t.getVendor().equalsIgnoreCase(vendor))) {
            System.out.println("No entries found for vendor: " + vendor);
        }

        promptReturnToReports();
    }

    private static void runPreviousYearReport() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime startOfLastYear = now.minusYears(1).withDayOfYear(1);
        LocalDateTime endOfLastYear = now.withDayOfYear(1);

        System.out.println("\nPrevious Year Report:\n");

        transactions.stream()
                .filter(t -> {
                    LocalDateTime transactionDate = LocalDateTime.parse(t.getDate());
                    return !transactionDate.isBefore(startOfLastYear) && transactionDate.isBefore(endOfLastYear);
                })
                .forEach(System.out::println);

        promptReturnToReports();
    }

    private static void runYearToDateReport() {
        LocalDateTime startOfYear = LocalDateTime.now().withDayOfYear(1);
        System.out.println("\nYear to Date Report:\n");

        transactions.stream()
                .filter(t -> LocalDateTime.parse(t.getDate()).isAfter(startOfYear))
                .forEach(System.out::println);

        promptReturnToReports();
    }

    private static void runPreviousMonthReport() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime startOfLastMonth = now.minusMonths(1).withDayOfMonth(1);
        LocalDateTime endOfLastMonth = now.withDayOfMonth(1);

        System.out.println("\nPrevious Month Report:\n");

        transactions.stream()
                .filter(t -> {
                    LocalDateTime transactionDate = LocalDateTime.parse(t.getDate());
                    return !transactionDate.isBefore(startOfLastMonth) && transactionDate.isBefore(endOfLastMonth);
                })
                .forEach(System.out::println);

        promptReturnToReports();
    }

    private static void runMonthToDateReport() {
        LocalDateTime startOfMonth = LocalDateTime.now().withDayOfMonth(1);
        System.out.println("\nMonth to Date Report:\n");

        transactions.stream()
                .filter(t -> LocalDateTime.parse(t.getDate()).isAfter(startOfMonth))
                .forEach(System.out::println);

        promptReturnToReports();

    }

    private static void promptReturnToReports() {
        System.out.println("\nPress Enter to return to the Reports Menu...");
        in.nextLine();
    }

    private static void displayPayments() {
        System.out.println("\nDisplaying Payments:\n");
        transactions.stream()
                .filter(t -> t.getAmount() < 0)
                .forEach(System.out::println); // Assumes Transactions has a proper toString()

        if (transactions.stream().noneMatch(t -> t.getAmount() < 0)) {
            System.out.println("No payment transactions found.");
        }

        System.out.println("\nPress Enter to return to the Ledger Home Screen...");
        in.nextLine();
        displayLedger(in); // Return to the Ledger menu


    }

    private static void displayDeposit() {
        System.out.println("\nDisplaying Deposits:\n");
        transactions.stream()
                .filter(t -> t.getAmount() > 0)
                .forEach(System.out::println); // Assumes Transactions has a proper toString()

        if (transactions.stream().noneMatch(t -> t.getAmount() > 0)) {
            System.out.println("No deposit transactions found.");
        }

        System.out.println("\nPress Enter to return to the Ledger Home Screen...");
        in.nextLine();
        displayLedger(in); // Return to the Ledger menu

    }

    private static void displayAll(Scanner in) {
        System.out.println("\nDisplaying All Transactions:\n");
        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            for (Transactions transaction : transactions) {
                System.out.println(transaction); // Assumes Transactions has a proper toString() method
            }
        }
        System.out.println("\nPress Enter to return to the Ledger Home Screen...");
        in.nextLine(); // Wait for user to press Enter
        displayLedger(in); // Return to the Ledger screen



    }


    public static void makePayment(Scanner in) {
        LocalDateTime now = LocalDateTime.now(); // used this so that the date and time autopopulated
        System.out.print("Enter Description: ");
        String description = in.next();
        System.out.print("Enter Vendor: ");
        String vendor = in.next();
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













