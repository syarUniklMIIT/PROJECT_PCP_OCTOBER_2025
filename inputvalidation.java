import java.util.Scanner;

//ref:https://ondrej-kvasnovsky.medium.com/java-101-lesson-14-input-validation-robustness-908331a56f3d

public class inputvalidation {

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
            if (isInRange(code, 1, 8)) {
                break;
            }
        }
        return code;
    }

    // check for valid movie selection
    String movie(Scanner scanner, String prompt) {
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
            } else if (code.equals("P")) {
                break;
            }

        }
        return code;
    }

    // check for valid time slot selection
    int time_slot(Scanner scanner, String prompt) {
        int i = 1;
        int code = 2;
        while (!(i == 0)) {
            code = getIntegerSafely(scanner, prompt);
            if (isInRange(code, 1, 2)) {
                break;
            }
        }
        return code;
    }

    // check for valid amount of seat they want to book(max 6)
    int amount_seat(Scanner scanner, String prompt) {
        int i = 1;
        int code = 2;
        while (!(i == 0)) {
            code = getIntegerSafely(scanner, prompt);
            if (isInRange(code, 1, 6)) {
                break;
            }
        }
        return code;
    }

    // check for yes and no confirmation
    String confirmation(Scanner scanner, String prompt) {
        int i = 1;
        String code = "G";
        while (!(i == 0)) {
            code = getStringSafely(scanner, prompt);
            if (code.equals("Yes")) {
                break;
            } else if (code.equals("No")) {
                break;
            }

        }
        return code;
    }

    // sub checker all below
    // check if the input is actually an integer
    int getIntegerSafely(Scanner scanner, String prompt) {
        System.out.println(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println(prompt);
            scanner.next(); // Clear the invalid input
        }
        return scanner.nextInt();// return scanner
    }

    // check if the input is string
    String getStringSafely(Scanner scanner, String prompt) {
        System.out.println(prompt);
        while (!scanner.hasNext()) {
            System.out.println(prompt);
            scanner.next(); // Clear the invalid input
        }
        return scanner.next();// return scanner
    }

    // return true if the value given is between min and max
    boolean isInRange(int value, int min, int max) {
        return value >= min && value <= max;
    }

    // allow the enter to continue so that the user can read the output before
    // continuing
    void pressEnterToContinue(Scanner keyboard) {
        System.out.println("Press Enter key to continue...");
        try {
            System.in.read();
            keyboard.nextLine();
            keyboard.close();
        } catch (Exception e) {
        }
    }
    // https://stackoverflow.com/questions/19870467/how-do-i-get-press-any-key-to-continue-to-work-in-my-java-code

}
