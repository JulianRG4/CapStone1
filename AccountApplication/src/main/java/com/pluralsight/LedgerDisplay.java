package com.pluralsight;

import java.util.List;
import java.util.Scanner;

public class LedgerDisplay {

    private static final Scanner userInput = new Scanner(System.in);

    public static void displayLedger() {
        String ledgerScreen = "";
        while (!ledgerScreen.equals("H")) {
            System.out.println();
            System.out.println("--------Ledger Screen--------");
            System.out.println();
            System.out.println("A) Display all Entries ");
            System.out.println("D) Display all Deposits ");
            System.out.println("P) Display all Payments ");
            System.out.println("R) Show Reports ");
            System.out.println("H) Return Home");

            ledgerScreen = userInput.nextLine().toUpperCase();

            switch (ledgerScreen) {
                case "A":
                    System.out.println();
                    allEntries();
                    System.out.println();
                    System.out.println("Press Enter to return ");
                    userInput.nextLine();
                    break;

                case "D":
                    System.out.println();
                    allDeposits();
                    System.out.println();
                    System.out.println("Press Enter to return ");
                    userInput.nextLine();
                    break;

                case "P":
                    System.out.println();
                    allPayments();
                    System.out.println();
                    System.out.println("Press Enter to return ");
                    userInput.nextLine();
                    break;

                case "R":
                    ReportsDisplay.displayReports();
                    break;

                case "H":
                    break;

                default:
                    System.out.println("Invalid input, Press Enter to try again.");
                    userInput.nextLine();
                    break;
            }
        }
    }

    public static void allEntries() {
        System.out.println("--------All Entries--------");
        System.out.println();

        List<Transactions> transactions = CSVReader.csvReader("Files/Transaction.csv");

        for (Transactions transaction : transactions) {
            System.out.println(transaction);
        }
    }

    public static void allDeposits() {
        System.out.println("--------All Deposits--------");
        System.out.println();

        List<Transactions> transactions = CSVReader.csvReader("Files/Transaction.csv");

        for (Transactions transaction : transactions) {
            if (transaction.getAmount() > 0) {
                System.out.println(transaction);
            }
        }
    }

    public static void allPayments() {
        System.out.println("--------All Payments--------");
        System.out.println();

        List<Transactions> transactions = CSVReader.csvReader("Files/Transaction.csv");

        for (Transactions transaction : transactions) {
            if (transaction.getAmount() < 0) {
                System.out.println(transaction);
            }
        }
    }
}