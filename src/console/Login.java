package console;

import data.User;
import data.dao.Storage;
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

            ConsoleUtil.displayChoiceText("Enter choice: ");

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
                    displayOptions(UserType.VET_DOCTOR);
                    break;
                case 4:
                    System.out.println("Exiting the system.");
                    System.exit(0);
                    break;
                default:
                    ConsoleUtil.displayError("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayOptions(UserType userType) {

        while (true) {
            switch (userType) {
                case PET_OWNER -> {
                    ConsoleUtil.clearConsole();
                    ConsoleUtil.displayChoiceText(" Enter Choice: ");
                    ConsoleUtil.displayOptionsText("1, Schedule an appointment");
                    ConsoleUtil.displayOptionsText("2, View appointment");
                    ConsoleUtil.displayOptionsText("3, View pets medical history");
                    ConsoleUtil.displayOptionsText("4, Logout");
                    ConsoleUtil.displayOptionsText("5, Exit");
                    int input = ConsoleUtil.getScanner().nextInt();

                    if (input == 1) {
                        AppointmentConsole.scheduleAppointment();
                    } else if (input == 2) {
                        MedicalRecordsConsole.viewMedicalRecords();
                    }else if (input == 3) {
                         Storage.getAppointments()
                                 .stream()
                                 .forEach(x -> ConsoleUtil.displayColoredMessage(x.toString(), ConsoleUtil.BLUE));
                    }else if (input == 4) {
                       userLogin();
                    }else if (input == 5) {
                       System.exit(0);
                    }
                }
                case ADMINISTRATOR -> {
                    ConsoleUtil.clearConsole();
                    ConsoleUtil.displayChoiceText(" Enter Choice: ");
                    ConsoleUtil.displayOptionsText("1. Add pet");
                    ConsoleUtil.displayOptionsText("2. Logout");
                    ConsoleUtil.displayOptionsText("3. Exit");
                    int input = ConsoleUtil.getScanner().nextInt();

                    if (input == 1) {
                        PetConsole.addPet();
                    }
                    else if (input == 2) {
                        userLogin();
                    }else if (input == 3) {
                        System.exit(0);
                    }

                }
                case VET_DOCTOR -> {
                    ConsoleUtil.clearConsole();
                    ConsoleUtil.displayChoiceText(" Enter Choice: ");
                    ConsoleUtil.displayOptionsText("1. Update Medical records");
                    ConsoleUtil.displayOptionsText("2. Logout");
                    ConsoleUtil.displayOptionsText("3. Exit");
                    int input = ConsoleUtil.getScanner().nextInt();

                    if (input == 1) {
                        MedicalRecordsConsole.updateMedicalRecord();
                    } else if (input == 2) {
                        userLogin();
                    }else if (input == 3) {
                        System.exit(0);
                    }

                }

            }
        }
    }

    private static User validateUserLogin(UserType userType) {
        while (true) {
            Map<String, String> info = loginForm();
            User user = userService.login(info.get("email"), info.get("password"), userType);
            if (user == null) {
                ConsoleUtil.displayError("Invalid email/password, please try again");
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
                ConsoleUtil.displayError("Invalid email format, please enter a valid email");
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
