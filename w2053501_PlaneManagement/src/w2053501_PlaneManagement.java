/**I declare that my work contains no examples of misconduct, such as plagiarism, or collusion.Any code taken from other sources is referenced within my code solution.
STUDENT ID : 20232343
UOW ID : w2053501*/
import java.io.File;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class w2053501_PlaneManagement {
    public static void main(String[] args) {
//          Setting up the Seats for the system
        String[][] seats = new String[4][];
        seats[0] = new String[14];
        seats[1] = new String[12];
        seats[2] = new String[12];
        seats[3] = new String[14];
        for (int i = 0; i < seats.length; i++) {
            int j;
            for (j = 0 ; j < seats[i].length; j++) {seats[i][j] = "0";}//  setting all values to zero to indicate the seats are not booked
        }
//        setting up the object Array which contains customer information
       Ticket[][] Customer_information= new Ticket[4][];
        Customer_information[0] = new Ticket[14];
        Customer_information[1] = new Ticket[12];
        Customer_information[2] = new Ticket[12];
        Customer_information[3] = new Ticket[14];
        System.out.print("<-----WELCOME TO THE PLANE MANAGEMENT SYSTEM----->\n");
        /**CALLING METHODS Of the Main Program*/
        Menu();
        System_main(seats,Customer_information);
    }
    public static void System_main(String [][] seats,Ticket[][] Customer_information ) {
//        menu box selecting options and its function
        try {
            Scanner input = new Scanner(System.in);
            System.out.print("Please select an option : ");
             int option = input.nextInt();
            if (option<0 ||option > 6) { // validating if the user input is between number 0 to 6
                System.out.println("Please choose a valid option to continue");
                System_main(seats,Customer_information);} // recursion  of the System_main method to loop within the method
        switch (option) {
            case 1:
                System.out.println("\nProcessing......:   Seat Booking \n");
                System.out.println("  SEAT ROWS AVAILABLE [A-B-C-D] \n  VIP CLASS - SEATS 1 TO 5 PRICE :€200 \n  PASSENGER CLASS - SEATS 6 TO 9 PRICE :€150 \n  BUSINESS CLASS - SEATS 10 TO 14 PRICE :€180 \n");
                Buy_seat(seats,Customer_information);// calling Buy_seat method
                break;
            case 2:
                System.out.println("\nProcessing......:   canceling Seat \n");
                Cancel_seat(seats,Customer_information);// calling Cancel_seat method
                break;
            case 3:
                System.out.println("\nProcessing......:   Finding First available Seat \n");
                find_first_available(seats);// calling find_first_available method
                break;
            case 4:
                System.out.println("\nProcessing......:   showing Available seats \n");
                Show_seating_plan(seats);// calling Show_seating_plan method
                break;
            case 5:
                System.out.println("\nprocessing ...... :    Displaying Ticket Details \n");
                Print_tickets_info(Customer_information);// calling  Print_tickets_info method
                break;
            case 6:
                System.out.println("\nprocessing ...... :    Searching Ticket Details \n");
                Search_Tickets(seats,Customer_information);// calling Search_Tickets method
                break;
            case 0:
                System.out.println("\nprocessing ...... :    Quiting Plane Ticket Management System ");//program sentinel value to exit
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + option);
        }
                if (!(option == 0)) {// runs only when the option is not the sentinel value
                    Scanner Scanner = new Scanner(System.in);
                    System.out.print("\npress Enter To go back to Main Menu... "); // waits until the  user  press enter to continue
                    while (true){
                         String enter =Scanner.nextLine();
                         if (enter.isEmpty()){break;}
                         else {System.out.println("press Enter To go back to Main Menu... ");}
                    }
                    System.out.println();
                    Menu();// calling menu before the program looping
                    System_main(seats, Customer_information);// recursion  of the System_main method to loop within the method
                }
        } catch (InputMismatchException e) {
            System.out.println("Please use a integer");
            System_main(seats,Customer_information);}// recursion  of the System_main method to loop within the method
}
    public  static void Menu(){// a method created to print the menu details
        System.out.println("************************************************** ");
        System.out.println("*                   MENU OPTIONS                 * ");
        System.out.println("************************************************** ");
        System.out.println("  1) Buy a seat  \n  2) Cancel a seat  \n  3) Find first available seat  \n  4) Show seating plan  \n  5) Print tickets information and total sales  \n  6) Search ticket  \n  0) Quit ");
        System.out.println("************************************************** ");
    }
    public static void Buy_seat(String [][] seats, Ticket [][] Customer_information){
        Scanner s = new Scanner(System.in);
        Pattern email_pattern = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"); // referenced at https://stackoverflow.com/questions/37853245/java-regex-issue-with-email-validation
        try {
            System.out.print("Enter Row Letter : ");
            String Seat_Row = s.next().toUpperCase();
            System.out.print("Enter Seat number : ");
            int Seat_number = s.nextInt();
            int row = Character.toUpperCase(Seat_Row.charAt(0)) - 'A';// getting the seat row's character's index where A contains value 0 ,B contains value 1 etc....
            int col = Seat_number - 1;// subtracting  1 to make sure it access the correct index  because index starts with 0 but seats start with 1
            if (!(Seat_Row.equals("A")||Seat_Row.equals("B")||Seat_Row.equals("C")||Seat_Row.equals("D"))) {// checking for the correct or incorrect  seat row and
                System.out.println("please enter a correct seat ");
                Buy_seat(seats,Customer_information);}// recursion  of the Buy_sea method to loop within the method
            else if (seats[row][col].equals("1")) {// check if the seat is already booked or not
                System.out.println("This seat is Already Booked\n");
                    Buy_seat(seats,Customer_information);// recursion  of the Buy_sea method to loop within the method
            return;}
            Scanner input = new Scanner(System.in);
            while (true) {// To validate a correct name
                System.out.print("Enter Your Name : ");
                String customer_Name = input.next();
                if (!customer_Name.matches("[a-zA-Z]+")){
                    System.out.println("Please enter a valid name.");
                    continue;
                }
                while (true) {//To validate  a correct surname
                    System.out.print("Enter Your Surname : ");
                    String customer_Surname = input.next();
                    if (!customer_Surname.matches("[a-zA-Z]+")) { // check if the user input matches ith the following regex format from simple alphabet and capital alphabet
                        System.out.println("Please enter a valid name.");
                        continue;
                    }
                    while (true) {// To validate the Email Address
                        System.out.print("Enter Your Email Address  : ");
                        String customer_Email = input.next();
                        Matcher matcher = email_pattern.matcher(customer_Email);// matchers the above pattern with the user input and check if it matchers to it
                        if (!matcher.matches()){// check if it doesn't match
                            System.out.println("Please enter a valid email address.");
                            continue;
                        }
                        Person customer = new Person(customer_Name, customer_Surname, customer_Email);// initializing the person object
                        int Price;// correct price distribution
                        if (col < 5) {
                            Price = 200;
                        } else if (col < 9) {
                            Price = 150;
                        } else {
                            Price = 180;
                        }
                        Ticket T1 = new Ticket(Seat_Row, Seat_number, customer, Price);// initializing the Ticket information to Ticket object
                        String ticket_s = Seat_Row + Seat_number; // ticket name for ticket saving purpose
                        if (row < 0 || row >= seats.length || col < 0 || col >= seats[row].length) {
                            System.out.println("Please select a valid seat ...... try again");
                            Buy_seat(seats, Customer_information);// recursion  of the Buy_sea method to loop within the method
                        } else {
                            seats[row][col] = "1";
                            Ticket Ticket_info = new Ticket(T1.getRow(), T1.getSeat(), customer, T1.getPrice());
                            Customer_information[row][col] = Ticket_info;// adding ticket object to the object array
                            System.out.println("Successfully Booked Seat Name " + Seat_Row + Seat_number);
                            T1.Save_ticket_info(ticket_s); // ticket saving

                        }break;
                    }break;
                }break;
            }
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException | NoSuchElementException e) {
            System.out.println("Please select a valid seat ......");
            Buy_seat(seats,Customer_information);}// recursion  of the Buy_sea method to loop within the method
    }
    private static void Cancel_seat(String [][] seats,Ticket [][] Customer_information){
        try {
            Scanner s = new Scanner(System.in);
            System.out.print("Enter Raw Name : ");
            String Seat_Row = s.nextLine().toUpperCase();
            System.out.print("Enter Seat number : ");
            int Seat_number = s.nextInt();
            int row = Character.toUpperCase(Seat_Row.charAt(0)) - 'A';// getting the seat row's character's index where A contains value 0 ,B contains value 1 etc....
            int col = Seat_number -1;// subtracting  1 to make sure it access the correct index  because index starts with 0 but seats start with 1
            String ticket_s = Seat_Row+ Seat_number;// ticket name for ticket saving purpose
            if (row<0 || row>= seats.length || col< 0 || col>= seats[row].length){
                System.out.println("Please select a valid seat ...... try again");
                Cancel_seat(seats,Customer_information);// recursion  of the Cancel_seat method to loop within the method
            }
            if (seats[row][col].equals("1")){
                seats[row][col] = "0";
                Customer_information[row][col] =null;// deleting ticket info if the ticket is canceled
                System.out.println("Successfully canceled Seat Name "+  Seat_Row+ Seat_number );
                File existingTicketFile = new File(ticket_s + ".txt");
                if (existingTicketFile.exists()) {existingTicketFile.delete();}// deleting ticket text file  if the ticket is canceled
            } else {System.out.println("\nThis seat is not yet Booked....!");}
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException | NoSuchElementException e) {
            System.out.println("Please select a valid seat ...... try again");
            Cancel_seat(seats,Customer_information);}// recursion  of the Cancel_seat method to loop within the method
    }
    private static void find_first_available(String[][] seats){
        for (int row= 0;row< seats.length;row++){
            for (int number =0;number<seats[row].length;number++){
                  if (seats[row][number].equals("0")){
                       System.out.println("The first seat available is "+ (char)('A'+row)+ (number+1));// calculating ascii value of char 'A' and adding it with row / adding 1 to make the index 0 to 1
                       return;
                  }
            }
        }
        System.out.println("All the seats are booked");
    }
    public static void Show_seating_plan(String[][] seats){
        for (int column=0;column < seats[0].length;column++){
            System.out.print("\t"+(column+1));// printing column numbers
        }
        System.out.println();
        for (int Raw =0;Raw< seats.length;Raw++){
            System.out.print((char)('A'+Raw)+": \t");// printing row Letters
            for (int no = 0; no < seats[Raw].length; no++){
                if (seats[Raw][no].equals("1")) {
                    System.out.print(seats[Raw][no] ="X" + "\t");//changing the seat value to X to show that the seat is booked
                    seats[Raw][no] ="1";// reassigning back to its original form after printing
                } else {System.out.print(seats[Raw][no] + "\t");}// printing the rest of the values of  the seats
            }System.out.println();
        }
    }
    public static void Print_tickets_info(Ticket[][] Customer_information) {
        int Total_Price = 0;
        int ticket_number=0;
        System.out.println("          Ticket Information          \n");
        for (Ticket[] row : Customer_information) {
            for (Ticket ticket : row) {
                if (ticket != null) {// checking if the ticket array is  not null
                    ticket_number++;
                    System.out.println("\n.........Details of Ticket "+ticket_number+".........");
                    ticket.ShowInfo();
                    System.out.println(".....................................");
                    Total_Price += ticket.getPrice();
                }
            }
        }System.out.println("\nTotal Ticket Sales: €"+Total_Price);
    }
    public static void Search_Tickets(String [][] seats,Ticket[][] Customer_information) {
        try {
            Scanner s = new Scanner(System.in);
            System.out.print("Enter Raw Name : ");
            String Seat_Row = s.nextLine().toUpperCase();
            System.out.print("Enter Seat number : ");
            int Seat_number = s.nextInt();
            int row = Character.toUpperCase(Seat_Row.charAt(0)) - 'A';// getting the seat row's character's index where A contains value 0 ,B contains value 1 etc....
            int col = Seat_number - 1;// subtracting  1 to make sure it access the correct index  because index starts with 0 but seats start with 1
            if (row >= 0 && row < seats.length && col >= 0 && col < seats[row].length) {
                if ((seats[row][col].equals("1"))) {
                    Ticket ticket = (Customer_information[row][col]);//setting correct index of which info that match to the corresponding seat searched
                    System.out.println("\n.........Details of Seat "+Seat_Row+Seat_number+".........");
                    ticket.ShowInfo();// printing ticket information
                    System.out.println(".....................................");
                } else {System.out.println("The Seat is Available");}
            } else {System.out.println("Invalid Seat Selection");
                Search_Tickets(seats, Customer_information);}// recursion  of the  Search_Tickets method to loop within the method
        }catch (ArrayIndexOutOfBoundsException | NumberFormatException | NoSuchElementException e){
            System.out.println("Invalid Seat Selection");
            Search_Tickets(seats, Customer_information);}// recursion  of the  Search_Tickets method to loop within the method
    }
}