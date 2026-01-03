import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        seating seats = new seating();
        booking books = new booking();

        String[] SeatA = { "1", "2", "3", "4", "5", "6", "7", "8", "1", "2", "3", "4", "5", "6", "7", "8", "1",
                "2", "3", "4", "5", "6", "7", "8", "1", "2", "3", "4", "5", "6", "7", "8", "1", "2", "3", "4", "5", "6",
                "7", "8", "1", "2", "3", "4", "5", "6", "7", "8" };
        String[] SeatB = new String[64];

        seats.initialiser(SeatA, SeatB);

        seats.display(SeatA);
        seats.display(SeatB);

        int num = 2;

        System.out.println(SeatA.length);

    }
}
