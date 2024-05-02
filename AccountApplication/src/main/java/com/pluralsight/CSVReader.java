package com.pluralsight;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

public class CSVReader {
    public static List<Transactions> csvReader(String filename) {
        List<Transactions> transactions = new ArrayList<>();
        File file = new File(filename);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\\|");
                LocalDate date = LocalDate.parse(parts[0], dateFormatter);
                LocalTime time = LocalTime.parse(parts[1].trim(), timeFormatter);
                String description = parts[2].trim();
                String vendor = parts[3].trim();
                double amount = Double.parseDouble(parts[4].trim());

                Transactions transaction = new Transactions(date, description, vendor, amount);
                transactions.add(transaction);
            }
        } catch (IOException | ArrayIndexOutOfBoundsException | NumberFormatException exception) {
            System.out.println("Sorry we ran into an error: " + exception.getMessage());
        }

        return transactions;
    }
}
