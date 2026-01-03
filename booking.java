
import java.util.Scanner;

public class booking {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        int stop = 0;
        while (!(stop == 1)) {

            System.out.println("____THEATER SCREEN_____");
            System.out.println();
            System.out.println("A"+seat[0]+seat[1]+"B")
            System.out.println("A"+seat[2]+seat[3]+"B")
            System.out.println();
            System.out.println("X = booked ");
            System.out.println("note:The ones with the numbers are still available.");
            System.out.println("Type in  the row that you want to book the seat in(type either A,B):");

            System.out.println("Type the seat number that you want to book(either 1,2,3,4):");
            System.out.println("System has booked your seat");
            System.out.println("Continue system?");
            stop = keyboard.nextInt();
        }

    }
}// 121212
