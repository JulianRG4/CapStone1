package com.pluralsight;


import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ReportsDisplay {

    private static final Scanner userInput = new Scanner(System.in);

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
            } catch (InputMismatchException exception) {
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

        List<Transactions> transactions = CSVReader.csvReader("Files/Transaction.csv");

        for (Transactions transaction : transactions) {
            if (!transaction.getDate().isBefore(startOfMonth) && !transaction.getDate().isAfter(today)) {
                System.out.println(transaction);
            }
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

        List<Transactions> transactions = CSVReader.csvReader("Files/Transaction.csv");

        for (Transactions transaction : transactions) {
            LocalDate transactionDate = transaction.getDate();
            if (!transactionDate.isBefore(firstDayOfPreviousMonth) && !transactionDate.isAfter(lastDayOfPreviousMonth)) {
                System.out.println(transaction);
            }
        }
    }

    public static void yearToDay() {
        LocalDate today = LocalDate.now();
        LocalDate startOfYear = today.withDayOfYear(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        System.out.println("--------Transactions from beginning of the year to today--------");
        System.out.println();

        List<Transactions> transactions = CSVReader.csvReader("Files/Transaction.csv");

        for (Transactions transaction : transactions) {
            LocalDate transactionDate = transaction.getDate();
            if (!transactionDate.isBefore(startOfYear) && !transactionDate.isAfter(today)) {
                System.out.println(transaction);
            }
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

        List<Transactions> transactions = CSVReader.csvReader("Files/Transaction.csv");

        for (Transactions transaction : transactions) {
            LocalDate transactionDate = transaction.getDate();
            if (!transactionDate.isBefore(startOfPreviousYear) && !transactionDate.isAfter(endOfPreviousYear)) {
                System.out.println(transaction);
            }
        }
    }

    public static void searchByVendor() {
        System.out.println("Enter the vendor name to search: ");
        String vendorName = userInput.nextLine();
        boolean found = false;

        System.out.println("--------Transactions for vendor: " + vendorName + "--------");
        System.out.println();

        List<Transactions> transactions = CSVReader.csvReader("Files/Transaction.csv");

        for (Transactions transaction : transactions) {
            String vendor = transaction.getVendor();
            if (vendor.equalsIgnoreCase(vendorName)) {
                System.out.println(transaction);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No transactions found for vendor: " + vendorName);
        }
    }
}
