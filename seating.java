public class seating {
    // array code for available...
    int array_code(String movie, int time_slot) {
        int code;
        if (movie.equals("A")) {
            switch (time_slot) {
                case 1:
                    code = 0;
                    break;

                default:
                    code = 1;
                    break;
            }
        } else if (movie.equals("B")) {
            switch (time_slot) {
                case 1:
                    code = 2;
                    break;

                default:
                    code = 3;
                    break;
            }

        } else {
            switch (time_slot) {
                case 1:
                    code = 4;
                    break;

                default:
                    code = 5;
                    break;
            }

        }
        return code;
    }

    // to be shown in the movie selection screen
    int availability(int[] seat, String movie, int time_slot) {
        int code = array_code(movie, time_slot);
        int value;
        if (seat[code] == 0)
            value = 0;
        else
            value = 1;

        return value;

    }

    // display for the booking screen
    void display(String[] seat) {

        System.out.println("   _________________________________________________");
        System.out.println("  |                 Theater Screen                  |");
        System.out.println("  |_________________________________________________|\n");
        // ----------------------------------A-----------------------------------------------------
        System.out.println(
                "A | ║ " + seat[0] + " ║║ " + seat[1] + " ║   ║ " + seat[2] + " ║║ " + seat[3] + " ║║ " + seat[4]
                        + " ║║ " + seat[5] + " ║    ║ " + seat[6] + " ║║ " + seat[7] + " ║ | A");
        System.err.println("  | ╚═══╝╚═══╝   ╚═══╝╚═══╝╚═══╝╚═══╝    ╚═══╝╚═══╝ | ");
        // =================================B===========================================================
        System.out.println(
                "B | ║ " + seat[8] + " ║║ " + seat[9] + " ║   ║ " + seat[10] + " ║║ " + seat[11] + " ║║ " + seat[12]
                        + " ║║ " + seat[13] + " ║    ║ " + seat[14] + " ║║ " + seat[15] + " ║ | B");

        System.err.println("  | ╚═══╝╚═══╝   ╚═══╝╚═══╝╚═══╝╚═══╝    ╚═══╝╚═══╝ | ");
        // ------------------------------------------------------------C----------------------------------
        System.out.println(
                "C | ║ " + seat[16] + " ║║ " + seat[17] + " ║   ║ " + seat[18] + " ║║ " + seat[19] + " ║║ " + seat[20]
                        + " ║║ " + seat[21] + " ║    ║ " + seat[21] + " ║║ " + seat[23] + " ║ | C");

        System.err.println("  | ╚═══╝╚═══╝   ╚═══╝╚═══╝╚═══╝╚═══╝    ╚═══╝╚═══╝ | ");
        // ----------------------------------------D--------------------------------------------------------
        System.out.println(
                "D | ║ " + seat[24] + " ║║ " + seat[25] + " ║   ║ " + seat[26] + " ║║ " + seat[27] + " ║║ " + seat[28]
                        + " ║║ " + seat[29] + " ║    ║ " + seat[30] + " ║║ " + seat[31] + " ║ | D");

        System.err.println("  | ╚═══╝╚═══╝   ╚═══╝╚═══╝╚═══╝╚═══╝    ╚═══╝╚═══╝ | ");
        // -----------------------------------------------E--------------------------------------------------
        System.out.println(
                "E | ║ " + seat[32] + " ║║ " + seat[33] + " ║   ║ " + seat[34] + " ║║ " + seat[35] + " ║║ " + seat[36]
                        + " ║║ " + seat[37] + " ║    ║ " + seat[38] + " ║║ " + seat[39] + " ║ | E");

        System.err.println("  | ╚═══╝╚═══╝   ╚═══╝╚═══╝╚═══╝╚═══╝    ╚═══╝╚═══╝ | ");
        // ---------------------------------------------------F-----------------------------------------------
        System.out.println(
                "F | ║ " + seat[40] + " ║║ " + seat[41] + " ║   ║ " + seat[42] + " ║║ " + seat[43] + " ║║ " + seat[44]
                        + " ║║ " + seat[45] + " ║    ║ " + seat[46] + " ║║ " + seat[47] + " ║ | F");

        System.err.println("  | ╚═══╝╚═══╝   ╚═══╝╚═══╝╚═══╝╚═══╝    ╚═══╝╚═══╝ | ");
        System.out.println("T : taken by others");
        System.out.println("X : booked by you");
        System.out.println("===========================================================================");
    }

    // initiaslise array used for seats booking
    void copy(String[] origin, String[] seat) {
        for (int i = 0; i < origin.length; i++) {
            seat[i] = origin[i];
        }

    }

    // finding the row and seat position array code
    int pos(String Row, int seat_position) {
        int code = 0;
        if (Row.equals("A")) {
            code = seat_position - 1;
        } else if (Row.equals("B")) {
            code = seat_position + 7;
        } else if (Row.equals("C")) {
            code = seat_position + 14;
        } else if (Row.equals("D")) {
            code = seat_position + 21;
        } else if (Row.equals("E")) {
            code = seat_position + 28;
        } else if (Row.equals("F")) {
            code = seat_position + 35;
        }
        return code;
    }
}
