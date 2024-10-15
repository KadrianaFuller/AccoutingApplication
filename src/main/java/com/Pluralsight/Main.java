package com.Pluralsight;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        int options;
        do{
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
                    addDeposit();
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


        }while (options!=4);


    }

    private static void displayLedger() {
    }

    private static void makePayment() {
    }


    public static void addDeposit(){
        System.out.println();


    }
}
