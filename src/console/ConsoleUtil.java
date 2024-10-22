package console;

import java.util.Scanner;

public class ConsoleUtil {

   public static Scanner scanner = new Scanner(System.in);



    public static final String RESET = "\u001B[0m"; // Resets the color
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    // Method to display a message in a specific color
    public static void displayColoredMessage(String message, String color) {
        System.out.println(color + message + RESET);
    }

    // Erase the current line and return to the beginning
    public static void clearLine() {
        // '\033[K' clears the rest of the line after the cursor
        System.out.print("\r\033[K");
    }

    // Method to clear the entire console
    public static void clearConsole() {
        // Clears the console and moves the cursor to the top-left corner
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
