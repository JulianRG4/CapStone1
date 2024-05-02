# CapStone1
---Classes- Main, Home Display, Ledger Display, Reports Dispaly, CSV Reader, Transactions, and Colors 

---Main- Calls In "HomeDisplay.main(args);" to start application 

---Home Display - Contains addDeposit, addPayment, LedgerDisplay, and Exit
-addDeposit and addPayment use the Transactions class to write userinput into the CSV file.
//LocalDate date = LocalDate.now();
        LocalTime time =LocalTime.now();

        Transactions deposit = new Transactions(date,time, description, vendor, amount);

        try {
            FileWriter writer = new FileWriter("Files/Transaction.csv", true);
            writer.write(deposit.toCsvString() + "\n");
            writer.close();
//
-LedgerDisplay takes you to the ledger 
-I also mutilplied the payment result by -1 to make the number negative and better sort through when displaying all pyments 

---LedgerDisplay- Contains allEntries, allDeposits, allPayments, ReportsDisplay, and Home
-This contains all of the funtions to display all requested inputs.
-I Originally was doing this by reading straight from the Files/Transaction file but latter made a CSVReader class to handle that.
-All Displays also display the latest transactions first by using "Collections.reverse(transactions);" to reverse the string.
-In this class I also had to start putting an extra userInput.nextLine(); or els when I scrolled it would take that as an imput and display an error in my next screen.

---ReportsDisplay- Contains month ToDay, PreviousMonth, YearToDay, PreviousYear, SearchByVendor, and return.
These were a bit different because they used ints and also had 0 as the return option. in this case I ended up making the displayReports equal to -1 to open up the 0.
// public static void displayReports() {
        int reportsScreen = -1;
        while (reportsScreen != 0) {
//
-I also had to add another userInput to not break the code when scroling.
-I also fixed an error that would allow me to press enter multiple times without giving me an error code. this was fixed by adding another String variable since we were looking for an int. 
```java
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
```
-I also had to add another catch statment so that it would actually give me an error code and not break my code with an error. 
-The logic for finding specific day was interesting, for example 
// if (!transactionDate.isBefore(startOfPreviousYear) && !transactionDate.isAfter(endOfPreviousYear))
//
-This says that if the day is not after the start of the first day of last year; give me the days. The second part says if the day is not after the last day of last year to give the days which then gives you all the days inbetween the first and last day of the previous year. This logic made me happy because it was hard to think through but also aloowed me to learn alot. 
-This screen was the main one that showed me new methods to do things and grew my understanding because I had to learn alot. I also had to make a class to read the CSV file for this in order to reverse the names and search by vendor more easily. 

---CSVReader- This reads the CSV files whenever it is called and makes an arraylist of the file so that I can easily split it if needed or format it how I would like. 
-I didn now start with this class and like mentioned before was reading from the file directly at the start. This allowed me to replace redundent code and have more flexability.
```java
 String line = scanner.nextLine();
                String[] parts = line.split("\\|");
                LocalDate date = LocalDate.parse(parts[0], dateFormatter);
                LocalTime time = LocalTime.parse(parts[1].trim(), timeFormatter);
                String description = parts[2].trim();
                String vendor = parts[3].trim();
                double amount = Double.parseDouble(parts[4].trim());
```
-Something interesting was that I originally didnt use the time variable because I was using LocalTime.Now and only added it because I needed it to keep the order of sections. I later relized I needed to use it instead of the LocalTime.Now and put it into effect. 
-Moving this class from the main file broke alot of things for me and was a challange because I was used to do my code in one class. This CapStone allowed me to expand on this. 

---Transaction class- Contains the variables, formatter, and constructor for when I want to write to the CSV file. 
-I used a formatter to get the time and day format I needed. 
-In tis class I also later made a second String file. "toString: writes to the cosole and the "toCsvString" wrtites to the file. these are the same exept toString has a -30 after the % in order to organize them into colums.
toString
```java
-return String.format("%-30s|%-30s|%-30s|%-30s|%-30.2f", formattedDate, formattedTime, description, vendor, amount);
```
-toCsvString
```java
 return String.format("%s|%s|%s|%s|%.2f", formattedDate, formattedTime, description, vendor, amount);
```

---Colors class- Contains my class to easily call in colors for UI reasons in my classes.
-It was cool learning about this because before I didnt know you could add colors 

---Overall 
-This project allowed me to grow and learn new things in a way that allowed me to practice and try the methods my self. I enjoyed this because actually having to problem solve and fix my code with minimal help was something challaning but also really fun. It makes me want to learn more and allocate more time to self projects. 
-There were some things that i still dont really feel confortable with. An example of this is making the classes. I still have to draft and write my starter code in one class. 
-Another thing I noticed was thats I tend to do alot of writing in my notebook or none at all. I restarted my code a few times just trying new ideas the forst day but this isnt shown in my docs. This is great becasue it showed me that I have other areas to grow in that arent just code related. 
The logic and way of thinking in this CapStone was also pretty different and a bit mroe advanced then I was used to which I liked. 

---Confident
-I feel confident in explaining and reading the logic and way of thinking I am using at the moment. By this I mean that I am not trying to go to ahead and feel I am in a good place.
-Switch statments are becoming more familiar and how to inbed multiple within each other. 

---Strugles
-I struggled with writing to the file and rhe understanding of the project at the start. I kept thinking I needed to add a savings, deposit, and more instead of just writing to the CSV file. 
-The array list was also hard for me at the start and was the main reason I used file reader.
-Getting started was the biggest thing I struggled with, I restarted multiple times and changed ideas as to how I would do my project. This was helped by drawing out my plan and workshopping for the first day with different styles and ideas. 

