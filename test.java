public class test {

}

public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    inputvalidation inputvalidation = new inputvalidation();
    // test for A,B,C,D,E,F
    // test for range(1,9) include 1 and 9
    // test for A,B,C movie selection
    // test for time slot selection 1,2 only

    System.out.println("1:rows\n2:pos\n3:movie selec\n4:time slot");
    System.out.println("ENter code(1,2,3,4 only):");
    int dec = keyboard.nextInt();
    if (dec == 1) {
        String row;
        row = inputvalidation.row(keyboard, "Enter either A,B,C,D,E,F only:");
        System.out.println("row:" + row);
    } else if (dec == 2) {
        System.out.println("enter either 1,2,3,4,5,6,7,8,9 only:");
    } else if (dec == 3) {
        System.out.println("Enter A,B,C only:");

    } else {
        System.out.println("enter either 1 or 2 only:");
    }

}