package com.pluralsight;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

public class Main {
    public static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        String homeScreen = "";

        while (!homeScreen.equals("X")) {
            System.out.println();
            System.out.println("--------Home Screen--------");
            System.out.println();
            System.out.println("D) Add Deposit");
            System.out.println("P) Make Payment (Debit)");
            System.out.println("L) Ledger");
            System.out.println("X) Exit");

            homeScreen = userInput.nextLine().toUpperCase();

            switch (homeScreen) {
                case "D":
                    addDeposit();
                    break;
                case "P":
                    addPayment();
                    break;
                case "L":
                    displayLedger();
                    break;
                case "X":
                    System.out.println("Exiting the application...");
                    break;
                default:
                    System.out.println("Invalid input, Press Enter to try again.");
                    userInput.nextLine();
                    break;
            }
        }
    }

    public static void addDeposit() {
        System.out.println();
        System.out.println("--------Deposit--------");
        System.out.println();
        System.out.print("Enter deposit description: ");
        String description = userInput.nextLine();

        System.out.print("Enter vendor: ");
        String vendor = userInput.nextLine();

        System.out.print("Enter amount: ");
        double amount = Double.parseDouble(userInput.nextLine());

        Transactions deposit = new Transactions(description, vendor, amount);

        try {
            FileWriter writer = new FileWriter("Files/Transaction.csv", true);
            writer.write(deposit.toString() + "\n");
            writer.close();
            System.out.println("Deposit Successfully Added!");
        } catch (IOException exception) {
            System.out.println("Sorry we ran into an Error");
        }
    }

    public static void addPayment() {
        System.out.println();
        System.out.println("--------Payment--------");
        System.out.println();
        System.out.print("Enter payment description: ");
        String description = userInput.nextLine();

        System.out.print("Enter vendor: ");
        String vendor = userInput.nextLine();

        System.out.print("Enter amount: ");
        double amount = Double.parseDouble(userInput.nextLine());
        amount *= -1;

        Transactions payment = new Transactions(description, vendor, amount);

        try
        {
            FileWriter writer = new FileWriter("Files/Transaction.csv", true);
            writer.write(payment.toString() + "\n");
            writer.close();
            System.out.println("Payment Successfully Added!");
        } catch (IOException exception) {
            System.out.println("Sorry we ran into an error");
        }
    }

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
                    displayReports();
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
        File file = new File("Files/Transaction.csv");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();
        } catch (IOException exception) {
            System.out.println("Sorry we ran into an error");
        }
    }

    public static void allDeposits() {
        System.out.println("--------All Deposits--------");
        System.out.println();
        File file = new File("Files/Transaction.csv");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\\|");
                double amount = Double.parseDouble(parts[4]);
                if (amount > 0) {
                    System.out.println(line);
                }
            }
            scanner.close();
        } catch (IOException exception) {
            System.out.println("Sorry we ran into an error");
        }
    }

    public static void allPayments() {
        System.out.println("--------All Payments--------");
        System.out.println();
        File file = new File("Files/Transaction.csv");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\\|");
                double amount = Double.parseDouble(parts[4]);
                if (amount < 0) {
                    System.out.println(line);
                }
            }
            scanner.close();
        } catch (IOException exception) {
            System.out.println("Sorry we ran into an error");
        }
    }

    public static void displayReports() {
        int reportsScreen = -1;
        while (reportsScreen != 0) {
            System.out.println();
            System.out.println("--------Reports Screen--------");
            System.out.println();
            System.out.println("1) Month to Date");
            System.out.println("2) Previous Month");
            System.out.println("3) year to Date");
            System.out.println("4) Previous year");
            System.out.println("5) Search By Vendor");
            System.out.println("0) Return to Reports");

            try {
                reportsScreen = userInput.nextInt();
                userInput.nextLine();

                switch (reportsScreen) {
                    case 1:
                        monthToDay();
                        System.out.println("Press Enter to Return");
                        userInput.nextLine();
                        break;

                    case 2:
                        previousMonth();
                        System.out.println("Press Enter to Return");
                        userInput.nextLine();
                        break;

                    case 3:
                        yearToDay();
                        System.out.println("Press Enter to Return");
                        userInput.nextLine();
                        break;

                    case 4:
                        previousYear();
                        System.out.println("Press Enter to Return");
                        userInput.nextLine();
                        break;

                    case 5:
                        searchByVendor();
                        System.out.println("Press Enter to Return");
                        userInput.nextLine();
                        break;

                    case 0:
                        break;

                    default:
                        System.out.println("Invalid input, Press Enter to try again.");
                        userInput.nextLine();

                }
            }catch (InputMismatchException exception)
            {
                System.out.println("Sorry, Please enter a valid number");
                System.out.println("Press enter to try again");
                userInput.nextLine();
                userInput.nextLine();
            }
        }
    }

    public static void monthToDay() {
        LocalDate today = LocalDate.now();
        LocalDate startOfMonth = today.withDayOfMonth(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        System.out.println("--------Transactions from beginning of the month to today--------");
        System.out.println();
        File file = new File("Files/Transaction.csv");

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\\|");
                LocalDate transactionDate = LocalDate.parse(parts[0], formatter);
                if (!transactionDate.isBefore(startOfMonth) && !transactionDate.isAfter(today)) {
                    System.out.println(line);
                }
            }
            scanner.close();
        } catch (IOException exception) {
            System.out.println("Sorry we ran into an error");
        }
    }

    public static void previousMonth() {
        LocalDate today = LocalDate.now();
        LocalDate firstDayOfCurrentMonth = today.withDayOfMonth(1);
        LocalDate firstDayOfPreviousMonth = firstDayOfCurrentMonth.minusMonths(1);
        LocalDate lastDayOfPreviousMonth = firstDayOfCurrentMonth.minusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        System.out.println("--------Transactions from the previous month--------");
        System.out.println();
        File file = new File("Files/Transaction.csv");

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\\|");
                LocalDate transactionDate = LocalDate.parse(parts[0], formatter);
                if (!transactionDate.isBefore(firstDayOfPreviousMonth) && !transactionDate.isAfter(lastDayOfPreviousMonth)) {
                    System.out.println(line);
                }
            }
            scanner.close();
        } catch (IOException exception) {
            System.out.println("Sorry we ran into an error");
        }
    }

    public static void yearToDay() {
        LocalDate today = LocalDate.now();
        LocalDate startOfYear = today.withDayOfYear(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        System.out.println("--------Transactions from beginning of the year to today--------");
        System.out.println();
        File file = new File("Files/Transaction.csv");

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\\|");
                LocalDate transactionDate = LocalDate.parse(parts[0], formatter);
                if (!transactionDate.isBefore(startOfYear) && !transactionDate.isAfter(today)) {
                    System.out.println(line);
                }
            }
            scanner.close();
        } catch (IOException exception) {
            System.out.println("Sorry we ran into an error");
        }
    }

    public static void previousYear() {
        LocalDate today = LocalDate.now();
        LocalDate startOfCurrentYear = today.withDayOfYear(1);
        LocalDate startOfPreviousYear = startOfCurrentYear.minusYears(1);
        LocalDate endOfPreviousYear = startOfCurrentYear.minusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        System.out.println("--------Transactions from the previous year--------");
        System.out.println();
        File file = new File("Files/Transaction.csv");

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\\|");
                LocalDate transactionDate = LocalDate.parse(parts[0], formatter);
                if (!transactionDate.isBefore(startOfPreviousYear) && !transactionDate.isAfter(endOfPreviousYear)) {
                    System.out.println(line);
                }
            }
            scanner.close();
        } catch (IOException exception) {
            System.out.println("Sorry we ran into an error");
        }
    }

    public static void searchByVendor() {
        System.out.println("Enter the vendor name to search: ");
        String vendorName = userInput.nextLine();
        boolean found = false;

        System.out.println("--------Transactions for vendor: " + vendorName + "--------");
        System.out.println();

        File file = new File("Files/Transaction.csv");

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\\|");
                String vendor = parts[3];
                if (vendor.equalsIgnoreCase(vendorName)) {
                    System.out.println(line);
                    found = true;
                }
            }
            scanner.close();
        } catch (IOException exception) {
            System.out.println("Sorry we ran into an error");
        }

        if (!found) {
            System.out.println("No transactions found for vendor: " + vendorName);
        }
    }
}

