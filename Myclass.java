import java.util.Scanner;

public class Myclass {

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

                // example of booking screen for client
                seats.display(current_seat);

                System.out.print("Type in  the row that you want to book the seat in(type either A,B):");
                // Enter the row
                Seat_Row = keyboard.next();

                System.out.print("Type the seat number that you want to book(either 1,2,3,4):");
                // request user to enter seat position in the row
                Seat_position = keyboard.nextInt();

                if ("A".equals(Seat_Row)) {// row A
                    current_seat[Seat_position] = "B";
                } else if ("B".equals(Seat_Row)) {// row B
                    current_seat[Seat_position + 2] = "B";
                }
                selected_seat[i] = Seat_Row + Seat_position;
            }
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
                seat[a] = current_seat[a];
            }
            seats.display(seat);

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
        String[] TB1 = new String[TEX.length];

        seats.initialiser(TEX, TA1);
        seats.initialiser(TEX, TB1);

        // var to make inf loop
        int Stop = 0;
        ;
        // system starts here
        while (Stop != 1) {
            // display movie info and name
            System.out.println("A: Movie A");

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

            // requires a if else statement here to intro booking method
            booking(TB1, num);

        }
        // System off
        System.out.println("Turning System off!!!!");
    }

}
