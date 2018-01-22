import bal.Reports;

import java.util.Scanner;

public class ConsoleUI {
    public ConsoleUI() {
        Reports reports = new Reports();

        try {
            boolean exit = false;
            while (!exit) {
                System.out.printf("1. Report on free printed products.\n" +
                        "2. Report on pupils who have more than one book.\n" +
                        "3. Report on pupils who have less than two books.\n" +
                        "0. EXIT.\n");
                System.out.printf("");
                Scanner in = new Scanner(System.in);
                int input = in.nextInt();
                switch (input) {
                    case 1:
                        System.out.printf(reports.reportOne());
                        break;
                    case 2:
                        System.out.printf(reports.reportTwo());
                        break;
                    case 3:
                        System.out.printf(reports.reportThree());
                        break;
                    case 0:
                        exit = true;
                        break;
                    default:
                        break;
                }

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
