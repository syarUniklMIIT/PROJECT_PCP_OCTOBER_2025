import java.util.Scanner;

//ref:https://ondrej-kvasnovsky.medium.com/java-101-lesson-14-input-validation-robustness-908331a56f3d

public class inputvalidation {

    // Scanner keyboard = new Scanner(System.in);

    // main testing for inputvalidation
    public void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        // test for A,B,C,D,E,F
        // test for range(1,9) include 1 and 9
        // test for A,B,C movie selection
        // test for time slot selection 1,2 only

        System.out.println("1:rows\n2:pos\n3:movie selec\n4:time slot");
        System.out.println("ENter code(1,2,3,4 only):");
        int dec = keyboard.nextInt();
        if (dec == 1) {
            String row;
            row = row(keyboard, "Enter either A,B,C,D,E,F only:");
            System.out.println("row:" + row);
        } else if (dec == 2) {
            int pos;
            pos = pos(keyboard, "enter either 1,2,3,4,5,6,7,8,9 only:");
            System.out.println("pos:" + pos);
        } else if (dec == 3) {
            System.out.println("Enter A,B,C only:");

        } else {
            System.out.println("enter either 1 or 2 only:");
        }

    }

    // check for valid row selection
    String row(Scanner scanner, String prompt) {
        int i = 1;
        String code = "G";
        while (!(i == 0)) {
            code = getStringSafely(scanner, prompt);
            if (code.equals("A")) {
                break;
            } else if (code.equals("B")) {
                break;
            } else if (code.equals("C")) {
                break;
            } else if (code.equals("D")) {
                break;
            } else if (code.equals("E")) {
                break;
            } else if (code.equals("F")) {
                break;
            }

        }
        return code;
    }

    // check for valid seat position input
    int pos(Scanner scanner, String prompt) {
        int i = 1;
        int code = 2;
        while (!(i == 0)) {
            code = getIntegerSafely(scanner, prompt);
            if (isInRange(code, 1, 9)) {
                break;
            }
        }
        return code;
    }

    // check if the input is actually an integer
    int getIntegerSafely(Scanner scanner, String prompt) {
        System.out.println(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input!" + prompt);
            scanner.next(); // Clear the invalid input
        }
        return scanner.nextInt();// return scanner
    }

    // check if the input is string
    String getStringSafely(Scanner scanner, String prompt) {
        System.out.println(prompt);
        while (!scanner.hasNext()) {
            System.out.println("Invalid input! Try again:");
            scanner.next(); // Clear the invalid input
        }
        return scanner.next();// return scanner
    }

    boolean isInRange(int value, int min, int max) {
        return value >= min && value <= max;
    }

}
