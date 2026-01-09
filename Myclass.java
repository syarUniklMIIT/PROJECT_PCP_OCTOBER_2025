import java.util.Scanner;

public class Myclass {

    // booking method() in myclass
    public static void booking(String[] seat, int num, double price, ticket ticket) {
        // call methods
        inputvalidation inputvalidation = new inputvalidation();
        Scanner keyboard = new Scanner(System.in);
        seating seats = new seating();

        String hello;

        String finish_booking = "N";

        while (finish_booking.equals("N")) {
            String[] current_seat = new String[seat.length];
            for (int a = 0; a < seat.length; a++) {
                current_seat[a] = seat[a];
            }
            String[] selected_seat = new String[num];
            for (int i = 0; i < num; i++) {

                // Initialise variable because the code doesnt want to work without doing that
                String Seat_Row = "G";
                int Seat_position = 16;
                int waiter = 0;
                int pos = 1;

                // display booking screen
                seats.display(current_seat);

                while (!(waiter == 1)) {

                    // Enter the row
                    // validate if the user entered a string and only accepts A to F
                    Seat_Row = inputvalidation.row(keyboard, "Enter in the seat row(A to F only):");

                    // request user to enter seat position in the row
                    // validate if the user entered a integer and accepts only from 1 to 8 only
                    Seat_position = inputvalidation.pos(keyboard,
                            "Enter the seat number  that you want to book(1 to 8 only):");
                    // find the array code that the position is located at
                    pos = seats.pos(Seat_Row, Seat_position);
                    // check if seat that the user want to book has been taken or is being hold by
                    // the system
                    if ((current_seat[pos].equals("X")) || current_seat[pos].equals("T")) {
                        System.out.println("Seat is booked by you already or taken already...\n\n");

                        // pauses the system so that the user can read it
                        System.out.println("Type anything to continue...");
                        hello = keyboard.next();
                    } else {
                        break;
                    }

                }
                // replaces the value in the array as X
                current_seat[pos] = "X";
                selected_seat[i] = Seat_Row + Seat_position;
            }

            // display the seating arrangement again
            seats.display(current_seat);
            // system will display all the seats want to book
            for (int b = 0; b < num; b++) {
                System.out.println(selected_seat[b]);
            }
            // system confirm if user wants the seat that they have selected
            String confirmation = inputvalidation.confirmation(keyboard,
                    "Is the seat listed the seat you wanted to book?(enter Yes or no):");
            if (confirmation.equals("No")) {
                continue;
            }
            // area to calculate payment
            System.out.println("your payment is here");

            double total_price = num * price;
            // display payment summary
            System.out.println("\n-------------------------------");
            System.out.println("         PAYMENT SUMMARY         ");
            System.out.println("---------------------------------");
            System.out.print("Total Amount to Pay:RM");
            System.out.printf("%.2f", total_price);
            System.out.println("\n");
            System.out.println("Please proceed with payment......");
            System.out.println("---------------------------------");

            System.out.println("Type anything to continue");// allows the user to see the payment summary before
                                                            // continuing
            hello = keyboard.next();

            finish_booking = "Y";

            // Changes the ones that is "X " to "T" to differentiate between which one has
            // already been taken and what the user is trying to book
            for (int a = 0; a < seat.length; a++) {
                if (current_seat[a].equals("X")) {
                    current_seat[a] = "T";
                }
            }

            // overwrite the main array for the movie time
            seats.copy(current_seat, seat);

            ticket.print_it(num, selected_seat);

        }

    }

    // main start
    public static void main(String[] args) {
        // place to initialise variables
        inputvalidation inputvalidation = new inputvalidation();
        Scanner keyboard = new Scanner(System.in);
        seating seats = new seating();
        ticket ticket = new ticket();

        String Movie_selected = "A";// iniy
        int Time_selected = 1;
        // initialiser for array
        String[] TEX = { "1", "2", "3", "4", "5", "6", "7", "8", "1", "2", "3", "4", "5", "6", "7", "8", "1",
                "2", "3", "4", "5", "6", "7", "8", "1", "2", "3", "4", "5", "6", "7", "8", "1", "2", "3", "4", "5", "6",
                "7", "8", "1", "2", "3", "4", "5", "6", "7", "8" };

        int[] seats_available = { 48, 48, 48, 48, 48, 5 };

        // created a variable for all the show times available for each movie
        String[] TA1 = new String[48];
        String[] TA2 = new String[48];
        String[] TB1 = new String[48];
        String[] TB2 = new String[48];
        String[] TC1 = new String[48];
        String[] TC2 = new String[48];

        // copy from TEX array to array for each show time
        seats.copy(TEX, TA1);
        seats.copy(TEX, TA2);
        seats.copy(TEX, TB1);
        seats.copy(TEX, TB2);
        seats.copy(TEX, TC1);
        seats.copy(TEX, TC2);

        // all Movie names
        String[] Movie = { "Avengers     ", "Inception    ", "Spirited Away" };
        // all show times
        String[] ShowTime = { "11:00 AM", "08:00 PM", "13:00 PM", "09:00 PM", "14:00 PM", "05:00 PM" };
        // all movie prices regardless of age
        double[] Movie_prices = { 15.00, 18.00, 20.00 };
        int Movie_Index;// used to determine the price of the tickets
        int num = 0;// var for amount of seats the user want to book
        // var to make inf loop
        int system_start = 0;

        // system starts here
        while (!(system_start == 1)) {
            // display movie name, showtime and
            System.out.println("==========================================================");
            System.out.println("                   TGV CINEMA                           ");
            System.out.println("==========================================================");
            System.out.print("A:" + Movie[0] + " | RM");
            System.out.printf("%.2f", Movie_prices[0]);// prints the Movie price into 2 decimals
            System.out.println("\nShow time available:");
            System.out.println("| 1 |  " + ShowTime[0] + "||" + seats_available[0] + " seat(s) available.");
            System.out.println("| 2 |  " + ShowTime[1] + "||" + seats_available[1] + " seat(s) available.");
            System.out.println("-----------------------------------------------------------");
            System.out.print("B:" + Movie[1] + " | RM");
            System.out.printf("%.2f", Movie_prices[1]);// prints the Movie price into 2 decimals
            System.out.println("\nShow time available:");
            System.out.println("| 1 | " + ShowTime[2] + "||" + seats_available[2] + " seat(s) available.");
            System.out.println("| 2 | " + ShowTime[3] + "||" + seats_available[3] + " seat(s) available.");
            System.out.println("------------------------------------------------------------");
            System.out.print("C:" + Movie[2] + " | RM");
            System.out.printf("%.2f", Movie_prices[2]);// prints the Movie price into 2 decimals
            System.out.println("\nShow time available:");
            System.out.println("| 1 |" + ShowTime[4] + "|| " + seats_available[4] + " seat(s) available.");
            System.out.println("| 2 |" + ShowTime[5] + "|| " + seats_available[5] + " seat(s) available.");
            System.out.println("=============================================================");
            System.out.println("P : Power off");
            System.out.println("==============================================================");

            // movie selection and power off initiation
            // variable for infinite loop
            int r = 1;

            // check if the movie and time slot they want has not sold out
            while (!(r == 0)) {

                // validate if user input is a string and is only A,B,C,P(P only for shutdown)
                Movie_selected = inputvalidation.movie(keyboard,
                        "Enter the movie that you want to watch(A,B,C only) or P to power off :");
                if (Movie_selected.equals("P")) {// if the user inputs P
                    break;// break out of this loop and goes to power off confirmation...
                }

                // validate if the user entered a integer and its only 1,2 only
                Time_selected = inputvalidation.time_slot(keyboard,
                        "Enter the time slot you want to book for (1 or 2 )");
                int check_here = seats.availability(seats_available, Movie_selected, Time_selected);

                if (check_here == 0) {// repeat since they cant buy anything since all seats are taken
                    System.out.println("The time slot selected has sold out...");
                } else {
                    // request input from user and validates it making sure its at max 6
                    num = inputvalidation.amount_seat(keyboard, "Enter amount of seat to book(max 6 ):");
                    if (seats_available[seats.array_code(Movie_selected, Time_selected)] < num) {
                        System.out.println(
                                "The amount of seats that want to book exceeds the amount of seats available...");
                        System.out.println("Enter anything to continue....");
                        String hello = keyboard.next();
                        continue;

                    } else {
                        break;// break out of the infinite while loop
                    }
                }
            }

            // power off sequence confirmation....
            if ("P".equals(Movie_selected)) {
                String declaration;
                declaration = inputvalidation.confirmation(keyboard,
                        "Enter Yes to shut down the system OR enter No to go back to the main menu:");
                if ("Yes".equals(declaration)) {
                    break;// skips all to power down
                } else
                    continue;
            }
            // select amount of seats to book(max 6)
            // created variable for amount of seats user wanted to book

            // validate if the user entered a integer and its more than 0 and less than 6

            // set the amount values for the ticket seat array to store

            // if else statement for booking
            // Movie A
            if (Movie_selected.equals("A")) {
                Movie_Index = 0;
                ticket.Movie_name = Movie[0];// set Movie name for the ticket
                switch (Time_selected) {
                    case 1:// show time 1
                        ticket.Time_slot = ShowTime[0];
                        booking(TA1, num, Movie_prices[Movie_Index], ticket);
                        break;

                    default:// show time 2
                        ticket.Time_slot = ShowTime[1];
                        booking(TA2, num, Movie_prices[Movie_Index], ticket);
                        break;
                }
            } // Movie B
            else if (Movie_selected.equals("B")) {
                Movie_Index = 1;
                ticket.Movie_name = Movie[1];// set Movie name for the ticket
                switch (Time_selected) {
                    case 1:// show time 1
                        ticket.Time_slot = ShowTime[2];
                        booking(TB1, num, Movie_prices[Movie_Index], ticket);
                        break;

                    default:// show time 2
                        ticket.Time_slot = ShowTime[3];
                        booking(TB2, num, Movie_prices[Movie_Index], ticket);
                        break;
                }

            } // Movie C
            else {
                Movie_Index = 2;
                ticket.Movie_name = Movie[2];// set Movie name for the ticket
                switch (Time_selected) {
                    case 1:// show time 1
                        ticket.Time_slot = ShowTime[4];
                        booking(TC1, num, Movie_prices[Movie_Index], ticket);
                        break;

                    default:// show time 2
                        ticket.Time_slot = ShowTime[5];
                        booking(TC2, num, Movie_prices[Movie_Index], ticket);
                        break;
                }

            }
            // print the ticket that the user has purchased...

            System.out.println("type anything to continue:");
            String hello = keyboard.next();

            // find the array value for the selected movie and time
            int array_code = seats.array_code(Movie_selected, Time_selected);
            // the amounts of seats left - the amount of seats the user has booked
            seats_available[array_code] -= num;

            // end of the booking system menu code
        }
        // System turning off message
        System.out.println("Turning System off!!!!");

    }

}
