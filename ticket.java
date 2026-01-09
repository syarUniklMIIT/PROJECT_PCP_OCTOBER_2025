
public class ticket {
    String Movie_name;
    String Time_slot;

    public static void main(String[] args) {

    }

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
