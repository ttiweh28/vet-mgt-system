package console;

public class LoadingPage {

    // ANSI escape code to clear the line
    public static final String CLEAR_LINE = "\r\033[K";

    // ANSI escape code to reset the console formatting
    public static final String RESET = "\u001B[0m";

    // Main method to run the example
    public static void main(String[] args) {
        LoadingPage consoleIO = new LoadingPage();

        // Display large text first
        consoleIO.displayLargeText("Vet Management System");

        // Pause for 2 seconds before blinking
        //      consoleIO.flushAndSleep(2000);

        // Make "Vet Management System" blink 10 times with a 500ms delay
        //     consoleIO.blinkText("Vet Management System", 10, 500);

        // Display loading progress bar for 3 seconds
        consoleIO.displayLoadingBar(3);
    }

    // Method to display blinking text
    public void blinkText(String message, int blinkCount, int delayInMillis) {
        for (int i = 0; i < blinkCount; i++) {
            // Clear the line and display the message
            System.out.print(CLEAR_LINE + message);
            flushAndSleep(delayInMillis);

            // Clear the line to "erase" the message
            System.out.print(CLEAR_LINE);
            flushAndSleep(delayInMillis);
        }

        // Ensure the message stays visible after blinking ends
        System.out.println(message + RESET);
    }

    // Method to display a loading progress bar
    public void displayLoadingBar(int durationInSeconds) {
        int totalSteps = durationInSeconds * 10; // 10 updates per second
        System.out.print("Loading: [");

        for (int i = 0; i <= totalSteps; i++) {
            // Calculate the progress
            int progress = (i * 100) / totalSteps;

            // Display the progress bar
            System.out.print("\rLoading: [");
            int filledLength = progress / 5; // 20 fills for 100%
            for (int j = 0; j < 20; j++) {
                if (j < filledLength) {
                    System.out.print("█"); // Filled block
                } else {
                    System.out.print("░"); // Empty block
                }
            }
            System.out.print("] " + progress + "%");

            flushAndSleep(100); // Sleep for 100ms
        }
        System.out.println(); // Move to a new line after loading is complete
    }

    // Helper method to flush the output and sleep for the specified duration
    private void flushAndSleep(int millis) {
        System.out.flush();
        try {
            Thread.sleep(millis); // Sleep for the specified time
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Method to display large text (ASCII art)
    public void displayLargeText(String message) {
        // A simple representation of large text using ASCII art
        String[] lines = {
                "  __      __     _       _                __  __                                 _   _   _                ",
                " \\ \\    / /__ _| |__   | |__ _ __ ___ _ __|  \\/  | ___ _ __ __ _ _ __ ___   ___| |_| |_| |__   ___ _ __ __ _ ",
                "  \\ \\/\\/ / _ \\ | '_ \\  | '_ \\ '__/ _ \\ '__| |\\/| |/ _ \\ '__/ _` | '_ ` _ \\ / _ \\ __| __| '_ \\ / _ \\ '__/ _` |",
                "   \\  /  __/ | | | | | | | | | |  __/ |   | |  | |  __/ | | (_| | | | | | |  __/ |_| |_| | | |  __/ | | (_| |",
                "    \\/ \\___|_|_| |_| |_| |_| |_|\\___|_|   |_|  |_|\\___|_|  \\__,_|_| |_| |_|\\___|\\__|\\__|_| |_|\\___|_|  \\__,_|"
        };

        for (String line : lines) {
            System.out.println(line);
        }
    }
}
