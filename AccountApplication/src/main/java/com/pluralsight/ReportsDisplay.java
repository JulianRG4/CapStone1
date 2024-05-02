package com.pluralsight;


import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ReportsDisplay {

    private static final Scanner userInput = new Scanner(System.in);

    public static void displayReports() {

        String input = "";
        int reportsScreen = -1;
        while (reportsScreen != 0)
        {

            try {
                System.out.println(Colors.BLUE_BACKGROUND + " ");
                System.out.println(Colors.BLACK + ",--------------------------------------------------------------------------\n" +
                        "| CA|--------> U N I T E D   Y E A R   U P   B A Y N K <-------- ");
                System.out.println(Colors.BLACK + " -Reports Screen" + "-".repeat(15));
                System.out.println();
                System.out.println("[1] Month to Date");
                System.out.println("[2] Previous Month");
                System.out.println("[3] year to Date");
                System.out.println("[4] Previous year");
                System.out.println("[5] Search By Vendor");
                System.out.println("[0] Return to Reports");
                System.out.println("-".repeat(30));
                input =userInput.nextLine().strip().replace(" ", "");
                reportsScreen = Integer.parseInt(input);

                switch (reportsScreen) {
                    case 1:
                        monthToDay();
                        System.out.println();
                        System.out.println("-".repeat(150));
                        System.out.println("Press Enter to Return");
                        userInput.nextLine();
                        break;

                    case 2:
                        previousMonth();
                        System.out.println();
                        System.out.println("-".repeat(150));
                        System.out.println("Press Enter to Return");
                        userInput.nextLine();
                        break;

                    case 3:
                        yearToDay();
                        System.out.println();
                        System.out.println("-".repeat(150));
                        System.out.println("Press Enter to Return");
                        userInput.nextLine();
                        break;

                    case 4:
                        previousYear();
                        System.out.println();
                        System.out.println("-".repeat(150));
                        System.out.println("Press Enter to Return");
                        userInput.nextLine();
                        break;

                    case 5:
                        searchByVendor();
                        System.out.println();
                        System.out.println("-".repeat(150));
                        System.out.println("Press Enter to Return");
                        userInput.nextLine();
                        break;

                    case 0:
                        break;

                    default:
                        userInput.nextLine();
                        System.out.println(Colors.BLACK_BACKGROUND);
                        System.out.println(Colors.WHITE + "   __,_,\n" +
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

                }
            } catch (InputMismatchException exception) {
                userInput.nextLine();
                System.out.println(Colors.BLACK_BACKGROUND);
                System.out.println(Colors.WHITE + "   __,_,\n" +
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
                System.out.println(Colors.RED + "Sorry, we ran into an error." + Colors.RESET);
            }catch (Exception exception)
            {
                System.out.println(Colors.BLACK_BACKGROUND);
                System.out.println(Colors.WHITE + "   __,_,\n" +
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
                System.out.println(Colors.RED + "Sorry, we ran into an error." + Colors.RESET);

            }
        }
    }

    public static void monthToDay() {
        System.out.println(Colors.WHITE_BACKGROUND + " ");
        LocalDate today = LocalDate.now();
        LocalDate startOfMonth = today.withDayOfMonth(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        System.out.println("            ______              \n" +
                "         .-'      `-.           \n" +
                "       .'            `.         \n" +
                "      /                \\        \n" +
                "     ;                 ;`       \n" +
                "     |   Month to Day  |;       \n" +
                "     ;                 ;|\n" +
                "     '\\               / ;       \n" +
                "      \\`.           .' /        \n" +
                "       `.`-._____.-' .'         \n" +
                "         / /`_____.-'           \n" +
                "        / / /                   \n" +
                "       / / /\n" +
                "      / / /\n" +
                "     / / /\n" +
                "    / / /\n" +
                "   / / /\n" +
                "  / / /\n" +
                " / / /\n" +
                "/ / /\n" +
                "\\/_/");
        System.out.println("-Transactions from beginning of the month to today"  + "-".repeat(100));
        System.out.println("Date:                          Time:                          Description:                  Vendor:                        Amount:");

        List<Transactions> transactions = CSVReader.csvReader("Files/Transaction.csv");

        for (Transactions transaction : transactions) {
            if (!transaction.getDate().isBefore(startOfMonth) && !transaction.getDate().isAfter(today)) {
                System.out.println(transaction);
            }
        }
    }

    public static void previousMonth() {
        System.out.println(Colors.WHITE_BACKGROUND + " ");
        LocalDate today = LocalDate.now();
        LocalDate firstDayOfCurrentMonth = today.withDayOfMonth(1);
        LocalDate firstDayOfPreviousMonth = firstDayOfCurrentMonth.minusMonths(1);
        LocalDate lastDayOfPreviousMonth = firstDayOfCurrentMonth.minusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        System.out.println("            ______              \n" +
                "         .-'      `-.           \n" +
                "       .'            `.         \n" +
                "      /                \\        \n" +
                "     ;                 ;`       \n" +
                "     | Previous Month  |;       \n" +
                "     ;                 ;|\n" +
                "     '\\               / ;       \n" +
                "      \\`.           .' /        \n" +
                "       `.`-._____.-' .'         \n" +
                "         / /`_____.-'           \n" +
                "        / / /                   \n" +
                "       / / /\n" +
                "      / / /\n" +
                "     / / /\n" +
                "    / / /\n" +
                "   / / /\n" +
                "  / / /\n" +
                " / / /\n" +
                "/ / /\n" +
                "\\/_/");
        System.out.println("-Transactions from the previous month" + "-".repeat(110));
        System.out.println("Date:                          Time:                          Description:                  Vendor:                        Amount:");

        List<Transactions> transactions = CSVReader.csvReader("Files/Transaction.csv");

        for (Transactions transaction : transactions) {
            LocalDate transactionDate = transaction.getDate();
            if (!transactionDate.isBefore(firstDayOfPreviousMonth) && !transactionDate.isAfter(lastDayOfPreviousMonth)) {
                System.out.println(transaction);
            }
        }
    }

    public static void yearToDay() {
        System.out.println(Colors.WHITE_BACKGROUND + " ");
        LocalDate today = LocalDate.now();
        LocalDate startOfYear = today.withDayOfYear(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        System.out.println("            ______              \n" +
                "         .-'      `-.           \n" +
                "       .'            `.         \n" +
                "      /                \\        \n" +
                "     ;                 ;`       \n" +
                "     |   Year to Day   |;       \n" +
                "     ;                 ;|\n" +
                "     '\\               / ;       \n" +
                "      \\`.           .' /        \n" +
                "       `.`-._____.-' .'         \n" +
                "         / /`_____.-'           \n" +
                "        / / /                   \n" +
                "       / / /\n" +
                "      / / /\n" +
                "     / / /\n" +
                "    / / /\n" +
                "   / / /\n" +
                "  / / /\n" +
                " / / /\n" +
                "/ / /\n" +
                "\\/_/");
        System.out.println("-Transactions from beginning of the year to today" + "-".repeat(100));
        System.out.println("Date:                          Time:                          Description:                  Vendor:                        Amount:");

        List<Transactions> transactions = CSVReader.csvReader("Files/Transaction.csv");

        for (Transactions transaction : transactions) {
            LocalDate transactionDate = transaction.getDate();
            if (!transactionDate.isBefore(startOfYear) && !transactionDate.isAfter(today)) {
                System.out.println(transaction);
            }
        }
    }

    public static void previousYear() {
        System.out.println(Colors.WHITE_BACKGROUND + " ");
        LocalDate today = LocalDate.now();
        LocalDate startOfCurrentYear = today.withDayOfYear(1);
        LocalDate startOfPreviousYear = startOfCurrentYear.minusYears(1);
        LocalDate endOfPreviousYear = startOfCurrentYear.minusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        System.out.println("            ______              \n" +
                "         .-'      `-.           \n" +
                "       .'            `.         \n" +
                "      /                \\        \n" +
                "     ;                 ;`       \n" +
                "     |  Previous Year  |;       \n" +
                "     ;                 ;|\n" +
                "     '\\               / ;       \n" +
                "      \\`.           .' /        \n" +
                "       `.`-._____.-' .'         \n" +
                "         / /`_____.-'           \n" +
                "        / / /                   \n" +
                "       / / /\n" +
                "      / / /\n" +
                "     / / /\n" +
                "    / / /\n" +
                "   / / /\n" +
                "  / / /\n" +
                " / / /\n" +
                "/ / /\n" +
                "\\/_/");
        System.out.println("-Transactions from the previous year" + "-".repeat(114));
        System.out.println("Date:                          Time:                          Description:                  Vendor:                        Amount:");

        List<Transactions> transactions = CSVReader.csvReader("Files/Transaction.csv");

        for (Transactions transaction : transactions) {
            LocalDate transactionDate = transaction.getDate();
            if (!transactionDate.isBefore(startOfPreviousYear) && !transactionDate.isAfter(endOfPreviousYear)) {
                System.out.println(transaction);
            }
        }
    }

    public static void searchByVendor() {
        System.out.println(Colors.WHITE_BACKGROUND + " ");
        System.out.println("Enter the vendor name to search: ");
        String vendorName = userInput.nextLine();
        boolean found = false;

        System.out.println("            ______              \n" +
                "         .-'      `-.           \n" +
                "       .'            `.         \n" +
                "      /                \\        \n" +
                "     ;                 ;`       \n" +
                "     |      Vendor     |;       \n" +
                "     ;                 ;|\n" +
                "     '\\               / ;       \n" +
                "      \\`.           .' /        \n" +
                "       `.`-._____.-' .'         \n" +
                "         / /`_____.-'           \n" +
                "        / / /                   \n" +
                "       / / /\n" +
                "      / / /\n" +
                "     / / /\n" +
                "    / / /\n" +
                "   / / /\n" +
                "  / / /\n" +
                " / / /\n" +
                "/ / /\n" +
                "\\/_/");
        System.out.println("-Transactions for vendor: " + vendorName + "-".repeat(118));
        System.out.println("Date:                          Time:                          Description:                  Vendor:                        Amount:");

        List<Transactions> transactions = CSVReader.csvReader("Files/Transaction.csv");

        for (Transactions transaction : transactions) {
            String vendor = transaction.getVendor();
            if (vendor.equalsIgnoreCase(vendorName)) {
                System.out.println(transaction);
                found = true;
            }
        }

        if (!found) {
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
            System.out.println(Colors.RED + "No transactions found for vendor." + vendorName + Colors.RESET);
        }
    }
}
