import java.util.Scanner;

/**
 * Justin Tritinger - CMSC203
 * <p>
 * WiFi Diagnostic tool that runs through steps to find a solution for any current WiFi issues.
 */
public class WifiDiagnosis {

    public static void main(String[] args) {
        printHeader();
        runDiagnostics();
    }

    /** Display program header. */
    private static void printHeader() {
        System.out.println("If you have a problem with internet connectivity, this WiFi Diagnosis may work. \n");
    }

    /** Run WiFi diagnostic program, seeking user input until either a yes is found or end of program. */
    private static void runDiagnostics() {
        // Declare scanner for input
        Scanner stdin = new Scanner(System.in);
        // Suggestions to use
        String[] suggestions = new String[] {
                "Reboot your computer",
                "Reboot your router",
                "Make sure the cables to your router are plugged in firmly and your router is getting power",
                "Move your computer closer to your router"
        };
        // Step count
        String[] steps = new String[] {
                "First ",
                "Second",
                "Third ",
                "Fourth"
        };
        int n = 0;
        for (/*...*/; n < suggestions.length; n++) {
            System.out.println(steps[n] + " step: " + suggestions[n]);
            System.out.println("Now are you able to connect with the internet? (yes/no)");
            String input = stdin.nextLine();

            // Exit loop on confirmation
            if (input.equals("yes")) break;
        }

        if (n == suggestions.length) {
            System.out.println("Fifth step: Contact your ISP");
            System.out.println("Check with your ISP for any issues on your end or theirs.");
        } else {
            switch (n) {
                case 0 -> System.out.print("Rebooting your computer");
                case 1 -> System.out.print("Rebooting your router");
                case 2 -> System.out.print("Checking the router's cables");
                case 3 -> System.out.print("Moving your computer closer");
            }
            System.out.print(" seemed to work. \n");
        }

        // Print Class/Programmer Footer
        System.out.println("Programmer: Justin Tritinger - CMSC203");

        // Exit program (handles scanner usage)
        System.exit(0);

    }


}
