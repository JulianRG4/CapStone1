package com.pluralsight;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class HomeDisplay {

    private static final Scanner userInputScanner = new Scanner(System.in);

    public static void main(String[] args) {
        String userInput = "";

        while (!userInput.equals("X")) {
            System.out.println(Colors.BLUE_BACKGROUND + " ");
            System.out.println(Colors.BLACK + ",--------------------------------------------------------------------------\n" +
                    "| CA|--------> U N I T E D   Y E A R   U P   B A Y N K <-------- ");
            System.out.println( "-Home Screen--------");
            System.out.println();
            System.out.println("[D] Add Deposit");
            System.out.println("[P] Make Payment");
            System.out.println("[L] Ledger");
            System.out.println(Colors.RED + "[X] Exit" + Colors.BLACK);
            System.out.println();
            System.out.println("_\\/_                 |                _\\/_\n" +
                    "/o\\\\             \\       /            //o\\\n" +
                    " |                 .---.                |\n" +
                    "_|_______     --  /     \\  --     ______|__\n" +
                    "         `~^~^~^~^~^~^~^~^~^~^~^~`\n" +
                    "            ");
            System.out.println("-".repeat(75));
            System.out.println(Colors.RESET);

            userInput = userInputScanner.nextLine().toUpperCase();

            switch (userInput) {
                case "D":
                    addDeposit();
                    break;
                case "P":
                    addPayment();
                    break;
                case "L":
                    LedgerDisplay.displayLedger();
                    break;
                case "X":
                    System.out.println(Colors.BLACK_BACKGROUND + Colors.RED + "           ^^                   @@@@@@@@@\n" +
                            "      ^^       ^^            @@@@@@@@@@@@@@@\n" +
                            "                           @@@@@@@@@@@@@@@@@@              ^^\n" +
                            "                          @@@@@@@@@@@@@@@@@@@@\n" +
                            "~~~~ ~~ ~~~~~ ~~~~~~~~ ~~ &&&&&&&&&&&&&&&&&&&& ~~~~~~~ ~~~~~~~~~~~ ~~~\n" +
                            "~         ~~   ~  ~       ~~~~~~~~~~~~~~~~~~~~ ~       ~~     ~~ ~\n" +
                            "  ~      ~~      ~~ ~~ ~~  ~~~~~~~~~~~~~ ~~~~  ~     ~~~    ~ ~~~  ~ ~~ \n" +
                            "  ~  ~~     ~         ~      ~~~~~~  ~~ ~~~       ~~ ~ ~~  ~~ ~ \n" +
                            "~  ~       ~ ~      ~           ~~ ~~~~~~  ~      ~~  ~             ~~\n" +
                            "      ~             ~        ~      ~      ~~   ~             ~");
                    System.out.println("Exiting the application...");
                    break;
                default:
                    System.out.println(Colors.BLACK_BACKGROUND);
                    System.out.println("         __\n" +
                            " _(\\    |@@|\n" +
                            "(__/\\__ \\--/ __\n" +
                            "   \\___|----|  |   __\n" +
                            "       \\ }{ /\\ )_ / _\\\n" +
                            "       /\\__/\\ \\__O (__\n" +
                            "      (--/\\--)    \\__/\n" +
                            "      _)(  )(_\n" +
                            "     `---''---`");
                    System.out.println(Colors.RED + "Invalid input, Press Enter to try again." + Colors.RESET);
                    userInputScanner.nextLine();
                    System.out.println();
                    break;
            }
        }
    }

    public static void addDeposit() {
        System.out.println(Colors.GREEN_BACKGROUND + " ");
        System.out.println(Colors.BLACK + "-Deposit" + "-".repeat(28));
        System.out.println("|#######====================#######|\n" +
                "|#(1)*  UNITED Year UP BANK   *(1)#|\n" +
                "|#**          /===\\   ********  **#|\n" +
                "|*# {G}      | (\") |             #*|\n" +
                "|#*  ******  | /v\\ |    O N E    *#|\n" +
                "|#(1)         \\===/            (1)#|\n" +
                "|##===========DOLLAR=============##|\n" +
                "------------------------------------");
        System.out.println("Enter deposit description: ");
        String description = userInputScanner.nextLine();

        System.out.println("Enter vendor: ");
        String vendor = userInputScanner.nextLine();

        System.out.println("Enter amount: ");
        double amount = Double.parseDouble(userInputScanner.nextLine());

        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();

        Transactions deposit = new Transactions(date,time, description, vendor, amount);

        try {
            FileWriter writer = new FileWriter("Files/Transaction.csv", true);
            writer.write(deposit.toCsvString() + "\n");
            writer.close();
            System.out.println("                                   .''.       \n" +
                    "       .''.      .        *''*    :_\\/_:     . \n" +
                    "      :_\\/_:   _\\(/_  .:.*_\\/_*   : /\\ :  .'.:.'.\n" +
                    "  .''.: /\\ :   ./)\\   ':'* /\\ * :  '..'.  -=:o:=-\n" +
                    " :_\\/_:'.:::.    ' *''*    * '.\\'/.' _\\(/_'.':'.'\n" +
                    " : /\\ : :::::     *_\\/_*     -= o =-  /)\\    '  *\n" +
                    "  '..'  ':::'     * /\\ *     .'/.\\'.   '\n" +
                    "      *            *..*         :\n" +
                    "       *\n" +
                    "        *");
            System.out.println("Deposit Successfully Added!");
        } catch (IOException exception) {
            System.out.println(Colors.BLACK_BACKGROUND);;
            System.out.println("         __\n" +
                    " _(\\    |@@|\n" +
                    "(__/\\__ \\--/ __\n" +
                    "   \\___|----|  |   __\n" +
                    "       \\ }{ /\\ )_ / _\\\n" +
                    "       /\\__/\\ \\__O (__\n" +
                    "      (--/\\--)    \\__/\n" +
                    "      _)(  )(_\n" +
                    "     `---''---`");
            System.out.println(Colors.RED + "Sorry There Was an Error." + Colors.RESET);
        }
    }

    public static void addPayment() {
        System.out.println(Colors.RED_BACKGROUND + " ");
        System.out.println(Colors.BLACK + "                       000      00\n" +
                "                           0000000   0000\n" +
                "              0      00  00000000000000000\n" +
                "            0000 0  000000000000000000000000       0\n" +
                "         000000000000000000000000000000000000000 000\n" +
                "        0000000000000000000000000000000000000000000000\n" +
                "    000000000000000000000000000000000000000000000000\n" +
                "00000000000000000000000000000000000000000000000000000000\n" +
                "              / / / / / / / / / / / / / / / /\n" +
                "            / / / / / / / / / / / / / / /\n" +
                "            / / / / / / / / / / / / / / /\n" +
                "          / / / / / / / / / / / / / /\n" +
                "          / / / / / / / / / / / / /\n" +
                "        / / / / / / / / / / / /\n" +
                "        / / / / / / / / / /\n" +
                "\n" +
                "-Payment--------------------");
        System.out.println(Colors.BLACK );
        System.out.println("Enter payment description: ");
        String description = userInputScanner.nextLine();

        System.out.println("Enter vendor: ");
        String vendor = userInputScanner.nextLine();

        System.out.println("Enter amount: ");
        double amount = Double.parseDouble(userInputScanner.nextLine());
        amount *= -1;

        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();

        Transactions payment = new Transactions(date, time, description, vendor, amount);

        try {
            FileWriter writer = new FileWriter("Files/Transaction.csv", true);
            writer.write(payment.toCsvString() + "\n");
            writer.close();
            System.out.println("           |\n" +
                    "     \\     |     /\n" +
                    "       \\       /\n" +
                    "         ,d8b,           .,\n" +
                    " (')-\")_ 88888 ---   ;';'  ';'.\n" +
                    "('-  (. ')98P'      ';.,;    ,;\n" +
                    " '-.(   )'     \\       '.';.'\n" +
                    "           |     \\\n" +
                    "           |");
            System.out.println("Payment Successfully Added!");
        } catch (IOException exception) {
            System.out.println(Colors.BLACK_BACKGROUND);
            System.out.println("         __\n" +
                    " _(\\    |@@|\n" +
                    "(__/\\__ \\--/ __\n" +
                    "   \\___|----|  |   __\n" +
                    "       \\ }{ /\\ )_ / _\\\n" +
                    "       /\\__/\\ \\__O (__\n" +
                    "      (--/\\--)    \\__/\n" +
                    "      _)(  )(_\n" +
                    "     `---''---`");
            System.out.println(Colors.RED + "Sorry There Was an Error." + Colors.RESET);
        }
    }
}