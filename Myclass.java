import java.util.Scanner;

public class Myclass {

    // booking method() in myclass
    public static void booking(String[] seat, int num, int seat_available) {
        // call methods
        inputvalidation inputvalidation = new inputvalidation();
        Scanner keyboard = new Scanner(System.in);
        seating seats = new seating();

        String finish_booking = "N";

        while (finish_booking.equals("N")) {
            String[] current_seat = new String[seat.length];
            for (int a = 0; a < seat.length; a++) {
                current_seat[a] = seat[a];
            }
            String[] selected_seat = new String[num];
            for (int i = 0; i < num; i++) {

                // User input
                String Seat_Row = "G";
                int Seat_position = 16;
                int waiter = 0;
                int pos = 1;

                // display booking screen
                seats.display(current_seat);

                while (!(waiter == 1)) {

                    // Enter the row
                    Seat_Row = inputvalidation.row(keyboard, "Enter in the seat row(A to F only):");

                    // request user to enter seat position in the row
                    Seat_position = inputvalidation.pos(keyboard,
                            "Enter the seat number  that you want to book(1 to 8 only):");
                    pos = seats.pos(Seat_Row, Seat_position);
                    if ((current_seat[pos].equals("X")) || current_seat[pos].equals("T")) {
                        System.out.println("Seat is booked by you already or taken already...\n\n");
                    } else {
                        break;
                    }

                }
                current_seat[pos] = "X";
                selected_seat[i] = Seat_Row + Seat_position;
            }

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
            finish_booking = "Y";

            System.out.println("Thank you for your purchase:");
            System.out.println("Booking added to database");

            for (int a = 0; a < seat.length; a++) {
                if (current_seat[a].equals("X")) {
                    current_seat[a] = "T";
                }
            }

            for (int a = 0; a < seat.length; a++) {
                seat[a] = current_seat[a];
            }

        }

    }

    // main start
    public static void main(String[] args) {
        // place to initialise variables
        inputvalidation inputvalidation = new inputvalidation();
        Scanner keyboard = new Scanner(System.in);
        seating seats = new seating();

        String Movie_selected = "A";
        int Time_selected = 1;
        // initialiser for array
        String[] TEX = { "1", "2", "3", "4", "5", "6", "7", "8", "1", "2", "3", "4", "5", "6", "7", "8", "1",
                "2", "3", "4", "5", "6", "7", "8", "1", "2", "3", "4", "5", "6", "7", "8", "1", "2", "3", "4", "5", "6",
                "7", "8", "1", "2", "3", "4", "5", "6", "7", "8" };

        int[] seats_available = { 48, 48, 48, 48, 48, 48 };

        String[] TA1 = new String[TEX.length];
        String[] TA2 = new String[TEX.length];
        String[] TB1 = new String[TEX.length];
        String[] TB2 = new String[TEX.length];
        String[] TC1 = new String[TEX.length];
        String[] TC2 = new String[TEX.length];

        seats.initialiser(TEX, TA1);
        seats.initialiser(TEX, TA2);
        seats.initialiser(TEX, TB1);
        seats.initialiser(TEX, TB2);
        seats.initialiser(TEX, TC1);
        seats.initialiser(TEX, TC2);

        // var to make inf loop
        int Stop = 0;

        // system starts here
        while (Stop != 1) {
            // display movie info and name
            System.out.println("A:Movie A");
            System.out.println("Time slot available:");
            System.out.println("1. 11:00 AM");
            System.out.println("    " + seats_available[0] + " seat(s) available.");
            System.out.println("2. 08:00 PM");
            System.out.println("    " + seats_available[1] + " seat(s) available.");
            System.out.println("B:Movie B");
            System.out.println("Time slot available:");
            System.out.println("1. 13:00 PM");
            System.out.println("    " + seats_available[2] + " seat(s) available.");
            System.out.println("2. 09:00 PM");
            System.out.println("    " + seats_available[3] + " seat(s) available.");
            System.out.println("C:Movie C");
            System.out.println("Time slot available:");
            System.out.println("1. 14:00 PM");
            System.out.println("    " + seats_available[4] + " seat(s) available.");
            System.out.println("2. 05:00 PM");
            System.out.println("    " + seats_available[5] + " seat(s) available.");

            // movie selection and power off initiation
            int r = 1;
            while (!(r == 0)) {
                Movie_selected = inputvalidation.movie(keyboard,
                        "Enter the movie that you want to watch(A,B or C only):");
                Time_selected = inputvalidation.time_slot(keyboard,
                        "Enter the time slot you want to book for (1 or 2 )");
                int check_here = seats.availability(seats_available, Movie_selected, Time_selected);
                if (check_here == 0) {
                    System.out.println("The time slot selected has sold out...");
                } else {
                    break;
                }

            }

            // power off sequence verification
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
            int num;
            num = inputvalidation.amount_seat(keyboard, "Enter amount of seat to book(max 6 ):");

            // requires a if else statement here to intro booking method for multi movie
            // time slot
            if (Movie_selected.equals("A")) {
                switch (Time_selected) {
                    case 1:
                        booking(TA1, num, seats_available[0]);
                        break;

                    default:// 2
                        booking(TA2, num, seats_available[1]);
                        break;
                }
            } else if (Movie_selected.equals("B")) {
                switch (Time_selected) {
                    case 1:
                        booking(TB1, num, seats_available[2]);
                        break;

                    default:// 2
                        booking(TB2, num, seats_available[3]);
                        break;
                }
            } else {
                switch (Time_selected) {
                    case 1:
                        booking(TC1, num, seats_available[4]);
                        break;

                    default:// 2
                        booking(TC2, num, seats_available[5]);
                        break;
                }

            }
            int array_code = seats.array_code(Movie_selected, Time_selected);
            seats_available[array_code] -= num;

            // end of the booking system menu code
        }
        // System off
        System.out.println("Turning System off!!!!");
    }

}
