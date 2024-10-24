package console;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The type Console util.
 */
public class ConsoleUtil {

    public static final String RESET = "\u001B[0m"; // Resets the color
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    // Regular expression for validating email
    private static final String EMAIL_REGEX = "^[\\w-\\.]+@[\\w-]+\\.[a-zA-Z]{2,}$";

    public static boolean isValidEmail(String email) {
        // Compile regular expression
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        // Match email with the pattern
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    // Method to display a message in a specific color
    public static void displayError(String message) {
        System.out.println(RED + message + RESET);
    }

    // Method to display a message in a specific color
    public static void displayChoiceText(String message) {
        System.out.println(YELLOW + message + RESET);
    }

    // Method to display a message in a specific color
    public static void displayOptionsText(String message) {
        System.out.println(BLUE + message + RESET);
    }

    // Method to display a message in a specific color
    public static void displaySuccessMessage(String message) {
        System.out.println(PURPLE + message + RESET);
    }

    // Method to display a message in a specific color
    public static void displayColoredMessageWithNewLine(String message, String color) {
        System.out.println(color + message + RESET);
//        System.out.println(WHITE_BACKGROUND + color + message + RESET);
    }

    // Method to display a message in a specific color
    public static void displayColoredMessage(String message, String color) {
        System.out.print(color + message + RESET);
//        System.out.println(WHITE_BACKGROUND + color + message + RESET);
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

    public static Scanner getScanner() {
        System.out.print(BLUE);
        Scanner scanner = new Scanner(System.in);

        return scanner;

    }

    public static LocalDate dateValidation(String dateText) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        try {
            // Parse the date string into a LocalDate
            LocalDate date = LocalDate.parse(dateText, formatter);

            return date;
        } catch (DateTimeParseException e) {
            displayError("Invalid date format, please use MM/dd/yyyy");
        }
        return null;

    }

    public static LocalTime timeValidation(String timeText) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");

        try {
            // Parse the date string into a LocalDate
            LocalTime date = LocalTime.parse(timeText.toUpperCase(), formatter);

            return date;
        } catch (DateTimeParseException e) {
            displayError("Invalid time format, please use hh:mm am/pm");
        }
        return null;

    }

    public static LocalDateTime dateTimeValidation(String timeText) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a");

        try {
            // Parse the date string into a LocalDate
            LocalDateTime date = LocalDateTime.parse(timeText, formatter);

            return date;
        } catch (DateTimeParseException e) {
            displayError("Invalid date time format");
        }
        return null;
    }

    public static int intInputValidator(String message) {
        while (true) {
            displayChoiceText(message);
            String input = getScanner().nextLine();
            try {
                return Integer.parseInt(input);
            } catch (Exception e) {
                ConsoleUtil.displayError("Invalid input, enter only a number");
            }
        }
    }
}
