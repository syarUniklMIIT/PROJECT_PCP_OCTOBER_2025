public class seating {

    // display for the booking screen
    public static void display(String[] seat) {
        System.out.println("____________________________________________________|");
        System.out.println("                Theater Screen                      |");
        System.out.println("____________________________________________________|\n");
        System.out.println(
                "A | ║ " + seat[0] + " ║║ " + seat[1] + " ║   ║ " + seat[2] + " ║║ " + seat[3] + " ║║ " + seat[4]
                        + " ║║ " + seat[5] + " ║    ║ " + seat[6] + " ║║ " + seat[7] + " ║ | A");

        System.err.println("  | ╚═══╝╚═══╝   ╚═══╝╚═══╝╚═══╝╚═══╝    ╚═══╝╚═══╝ | ");
        System.out.println(
                "B | ║ " + seat[8] + " ║║ " + seat[9] + " ║   ║ " + seat[10] + " ║║ " + seat[11] + " ║║ " + seat[12]
                        + " ║║ " + seat[13] + " ║    ║ " + seat[14] + " ║║ " + seat[15] + " ║ | B");

        System.err.println("  | ╚═══╝╚═══╝   ╚═══╝╚═══╝╚═══╝╚═══╝    ╚═══╝╚═══╝ | ");
    }

    public static void initialiser(String[] origin, String[] seat) {
        for (int i = 0; i < origin.length; i++) {
            seat[i] = origin[i];
        }

    }
}
