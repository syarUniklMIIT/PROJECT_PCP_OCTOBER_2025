import java.util.Scanner;
import java.lang.Thread;

public class Myclass {

    // booking method() in myclass
    static void booking(String[] seat, int num) {
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
                String Seat_Row;
                int Seat_position;

                // display booking screen
                seats.display(current_seat);

                System.out.print("Type in  the row that you want to book the seat in(type either A,B,C,D,E,F):");
                // Enter the row
                Seat_Row = keyboard.next();

                System.out.print("Type the seat number that you want to book(either 1,2,3,4,5,6,7,8):");
                // request user to enter seat position in the row
                Seat_position = keyboard.nextInt();

                // selection for finding seating pos in array
                if ("A".equals(Seat_Row)) {// row A
                    current_seat[Seat_position - 1] = "X";
                } else if ("B".equals(Seat_Row)) {// row B
                    current_seat[Seat_position + 7] = "X";
                }
                selected_seat[i] = Seat_Row + Seat_position;
            }

            seats.display(current_seat);
            // system will display all the seats want to book
            for (int i = 0; i < num; i++) {
                System.out.println(selected_seat[i]);
            }
            // system confirm if user wants the seat that they have selected
            System.out.println("Is the seat listed the seat that you wanted to book?(enter Yes or No):");
            String confirmation = keyboard.next();
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
        Scanner keyboard = new Scanner(System.in);
        seating seats = new seating();

        String Movie_selected;
        // initialiser for array
        String[] TEX = { "1", "2", "3", "4", "5", "6", "7", "8", "1", "2", "3", "4", "5", "6", "7", "8", "1",
                "2", "3", "4", "5", "6", "7", "8", "1", "2", "3", "4", "5", "6", "7", "8", "1", "2", "3", "4", "5", "6",
                "7", "8", "1", "2", "3", "4", "5", "6", "7", "8" };
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
            System.out.println("2. 08:00 PM");
            System.out.println("B:Movie B");
            System.out.println("Time slot available:");
            System.out.println("1. 13:00 PM");
            System.out.println("2. 09:00 PM");
            System.out.println("C:Movie C");
            System.out.println("Time slot available:");
            System.out.println("1. 14:00 PM");
            System.out.println("2. 05:00 PM");

            // movie selection and power off initiation
            System.out.print("Select the movie you want to book(Type A,B or C):");
            Movie_selected = keyboard.next();

            // power off sequence verification
            if ("P".equals(Movie_selected)) {
                System.out.print("Shut down system?(Enter \"Y\" to shut down):");
                String declaration;
                declaration = keyboard.next();
                if ("Y".equals(declaration)) {
                    break;// skips all to power down
                } else
                    continue;
            }
            // select amount of seats to book(max 6)
            int num;
            System.out.print("Enter the amount of seats you want to book(max 6):");
            num = keyboard.nextInt();

            // requires a if else statement here to intro booking method for multi movie
            // time slot
            booking(TB1, num);

        }
        // System off
        System.out.println("Turning System off!!!!");
    }

}
