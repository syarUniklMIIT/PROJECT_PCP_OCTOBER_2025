
public class ticket {
    String Movie_name;// set the movie name for the ticket
    String Time_slot;// set the show time for the ticket

    public static void main(String[] args) {

    }

    // print out the tickets for the amount of seats the user has selected
    void print_it(int num, String[] Selected_Seat) {
        for (int i = 0; i < num; i++) {

            System.out.println("===================================");
            System.out.println("TGV CINEMA");
            System.out.println("TITTLE  :" + Movie_name);
            System.out.println("TIME    :" + Time_slot);
            System.err.println("Seat Number:\n" + Selected_Seat[i]);
            System.out.println("===================================");

        }

    }

}
