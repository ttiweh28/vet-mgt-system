package console;

import data.User;
import service.UserService;
import service.UserType;
import service.impl.UserServiceImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Login {

    public static User loggedInUser = null;
    static UserService userService = new UserServiceImpl();

    public static void userLogin() {

        ConsoleUtil.displayColoredMessageWithNewLine("\n1. Admin Login", ConsoleUtil.BLUE);
        ConsoleUtil.displayColoredMessageWithNewLine("\n2. Pet Owner Login", ConsoleUtil.BLUE);
        ConsoleUtil.displayColoredMessageWithNewLine("\n3. Veterinary Doctor Login", ConsoleUtil.BLUE);
        ConsoleUtil.displayColoredMessageWithNewLine("\n4. Exit", ConsoleUtil.BLUE);
        System.out.println();

        while (true) {

            ConsoleUtil.displayColoredMessage("Enter choice: ", ConsoleUtil.BLUE);

            int choice = ConsoleUtil.getScanner().nextInt();

            switch (choice) {
                case 1:
                    loggedInUser = validateUserLogin(UserType.ADMINISTRATOR);
                    displayOptions(UserType.ADMINISTRATOR);
                    break;
                case 2:
                    loggedInUser = validateUserLogin(UserType.PET_OWNER);
                    displayOptions(UserType.PET_OWNER);
                    break;
                case 3:
                    loggedInUser = validateUserLogin(UserType.VET_DOCTOR);
                    break;
                case 4:
                    System.out.println("Exiting the system.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayOptions(UserType userType) {

        switch (userType) {
            case PET_OWNER -> {
                ConsoleUtil.clearConsole();
                ConsoleUtil.displayColoredMessageWithNewLine(" Enter Choice: ", ConsoleUtil.BLUE);
                ConsoleUtil.displayColoredMessageWithNewLine("1, Schedule an appointment", ConsoleUtil.BLUE);
                ConsoleUtil.displayColoredMessageWithNewLine("2, View pets medical history", ConsoleUtil.BLUE);
                int input = ConsoleUtil.getScanner().nextInt();

                if (input == 1) {
                    AppointmentConsole.scheduleAppointment();
                } else if (input == 2) {
                    MedicalRecordsConsole.viewMedicalRecords();
                }
            }
            case ADMINISTRATOR -> {
                ConsoleUtil.clearConsole();
                ConsoleUtil.displayColoredMessageWithNewLine(" Enter Choice: ", ConsoleUtil.BLUE);
                ConsoleUtil.displayColoredMessageWithNewLine("1. Add pet", ConsoleUtil.BLUE);
                int input = ConsoleUtil.getScanner().nextInt();

                if (input == 1) {
                    PetConsole.addPet();
                }

            }
            case VET_DOCTOR -> {
                ConsoleUtil.clearConsole();
                ConsoleUtil.displayColoredMessageWithNewLine(" Enter Choice: ", ConsoleUtil.BLUE);
                ConsoleUtil.displayColoredMessageWithNewLine("1. Update Medical records", ConsoleUtil.BLUE);
                int input = ConsoleUtil.getScanner().nextInt();

                if (input == 1) {

                }

            }

        }
    }

    private static User validateUserLogin(UserType userType) {
        while (true) {
            Map<String, String> info = loginForm();
            User user = userService.login(info.get("email"), info.get("password"), userType);
            if (user == null) {
                ConsoleUtil.displayColoredMessageWithNewLine("Invalid email/password, please try again", ConsoleUtil.RED);
            } else {
                return user;
            }
        }
    }

    private static Map<String, String> loginForm() {

        Map<String, String> unamePword = new HashMap<>();
        String email = null;
        while (true) {
            ConsoleUtil.displayColoredMessageWithNewLine("Enter email: ", ConsoleUtil.BLUE);
            email = new Scanner(System.in).nextLine();
            boolean validEmail = ConsoleUtil.isValidEmail(email);
            if (!validEmail) {
                ConsoleUtil.displayColoredMessageWithNewLine("Invalid email format, please enter a valid email", ConsoleUtil.RED);
            } else {
                break;
            }
        }
        unamePword.put("email", email);
        ConsoleUtil.displayColoredMessageWithNewLine("Enter Password", ConsoleUtil.BLUE);
        String pword = ConsoleUtil.getScanner().nextLine();
        unamePword.put("password", pword);

        return unamePword;
    }
}
