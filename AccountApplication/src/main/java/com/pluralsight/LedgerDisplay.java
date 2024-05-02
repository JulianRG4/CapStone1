package com.pluralsight;

import java.util.List;
import java.util.Scanner;
import java.util.Collections;

public class LedgerDisplay {

    private static final Scanner userInput = new Scanner(System.in);

    public static void displayLedger() {
        String ledgerScreen = "";
        while (!ledgerScreen.equals("H")) {
            System.out.println(Colors.BLUE_BACKGROUND + " ");
            System.out.println(Colors.BLACK + "--------Ledger Screen--------");
            System.out.println();
            System.out.println("[A] Display all Entries ");
            System.out.println("[D] Display all Deposits ");
            System.out.println("[P] Display all Payments ");
            System.out.println("[R] Show Reports ");
            System.out.println("[H] Return Home");
            System.out.println("-".repeat(27));
            System.out.println(Colors.RESET);

            ledgerScreen = userInput.nextLine().toUpperCase();

            switch (ledgerScreen) {
                case "A":
                    allEntries();
                    System.out.println();
                    System.out.println("Press Enter to return ");
                    System.out.println("-".repeat(88));
                    userInput.nextLine();
                    userInput.nextLine();
                    break;

                case "D":
                    allDeposits();
                    System.out.println();
                    System.out.println("Press Enter to return ");
                    System.out.println("-".repeat(88));
                    userInput.nextLine();
                    userInput.nextLine();
                    break;

                case "P":
                    allPayments();
                    System.out.println();
                    System.out.println("Press Enter to return ");
                    System.out.println("-".repeat(88));
                    userInput.nextLine();
                   userInput.nextLine();
                    break;

                case "R":
                    ReportsDisplay.displayReports();
                    break;

                case "H":
                    break;

                default:
                    System.out.println(Colors.BLACK_BACKGROUND);
                    System.out.println("   __,_,\n" +
                            "  [_|_/ \n" +
                            "   //\n" +
                            " _//    __\n" +
                            "(_|)   |@@|\n" +
                            " \\ \\__ \\--/ __\n" +
                            "  \\o__|----|  |   __\n" +
                            "      \\ }{ /\\ )_ / _\\\n" +
                            "      /\\__/\\ \\__O (__\n" +
                            "     (--/\\--)    \\__/\n" +
                            "     _)(  )(_\n" +
                            "    `---''---`");
                    System.out.println(Colors.RED + "Invalid input, Press Enter to try again." + Colors.RESET);
                    userInput.nextLine();
                    userInput.nextLine();
                    break;
            }
        }
    }

    public static void allEntries() {
        System.out.println(Colors.WHITE_BACKGROUND + " ");
        System.out.println(Colors.BLACK + "-All Entries" + "-".repeat(75));
        System.out.println();

        List<Transactions> transactions = CSVReader.csvReader("Files/Transaction.csv");

        Collections.reverse(transactions);

        for (Transactions transaction : transactions) {
            System.out.println(transaction);
        }
    }

    public static void allDeposits() {
        System.out.println(Colors.GREEN_BACKGROUND + " ");
        System.out.println(Colors.BLACK + "-Deposit Screen" + "-".repeat(75));
        System.out.println();

        List<Transactions> transactions = CSVReader.csvReader("Files/Transaction.csv");

        Collections.reverse(transactions);

        for (Transactions transaction : transactions) {
            if (transaction.getAmount() > 0) {
                System.out.println(transaction);
            }
        }
    }

    public static void allPayments() {
        System.out.println(Colors.RED_BACKGROUND + " ");
        System.out.println(Colors.BLACK + "-Payments Screen" + "-".repeat(75));
        System.out.println();

        List<Transactions> transactions = CSVReader.csvReader("Files/Transaction.csv");

        Collections.reverse(transactions);


        for (Transactions transaction : transactions) {
            if (transaction.getAmount() < 0) {
                System.out.println(transaction);
            }
        }
    }
}