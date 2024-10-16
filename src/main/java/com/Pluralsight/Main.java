package com.Pluralsight;

import java.util.Scanner; // imported so I can use my scanner

public class Main {
    //  This line is my Access modifier, Return type , Identifier and the () is for the params
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); // allows users input


        int options; // used to define my options to store user's selection
        while (true){
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
                    makePayment();
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

    }


    public static void displayLedger() {
    }

    public static void makePayment() {
    }






    }

