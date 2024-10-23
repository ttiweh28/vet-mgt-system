package console;

import data.PetOwner;
import data.User;
import service.UserService;
import service.UserType;
import service.impl.UserServiceImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static console.ConsoleUtil.*;

public class Login {

    public static User loggedInUser = null;
    static UserService userService = new UserServiceImpl();

    public static void userLogin() {

        displayColoredMessageWithNewLine("\n1. Admin Login", BLUE);
        displayColoredMessageWithNewLine("\n2. Pet Owner Login", BLUE);
        displayColoredMessageWithNewLine("\n3. Veterinary Doctor Login", BLUE);
        displayColoredMessageWithNewLine("\n4. Exit", BLUE);
        System.out.println();

        while (true) {

            int choice = intInputValidator("Enter Choice: ");

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
                    displayError("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayOptions(UserType userType) {

        while (true) {
            switch (userType) {
                case PET_OWNER -> {
                    clearConsole();
                    displayChoiceText("Choose service: ");
                    displayOptionsText("1. Schedule an appointment");
                    displayOptionsText("2. View appointment");
                    displayOptionsText("3. View pets medical history");
                    displayOptionsText("4. Logout");
                    displayOptionsText("5. Exit");

                    int input = intInputValidator("Enter number: ");

                    if (input == 1) {
                        AppointmentConsole.scheduleAppointment();
                    } else if (input == 2) {
                        AppointmentConsole.viewAppointments((PetOwner) loggedInUser);
                    } else if (input == 3) {
                        MedicalRecordsConsole.viewMedicalRecords();
                    } else if (input == 4) {
                        userLogin();
                    } else if (input == 5) {
                        System.exit(0);
                    }
                }
                case ADMINISTRATOR -> {
                    clearConsole();
                    displayChoiceText("Choose service: ");
                    displayOptionsText("1. Add pet");
                    displayOptionsText("2. Logout");
                    displayOptionsText("3. Exit");
                    int input = intInputValidator("Enter number: ");

                    if (input == 1) {
                        PetConsole.addPet();
                    } else if (input == 2) {
                        // Clear the console using ANSI escape code
                        for (int i = 0; i < 100; i++) {
                            System.out.println();
                        }
                        userLogin();
                    } else if (input == 3) {
                        System.exit(0);
                    }

                }
                case VET_DOCTOR -> {
                    clearConsole();
                    displayChoiceText("Choose service: ");
                    displayOptionsText("1. Update Medical records");
                    displayOptionsText("2. Logout");
                    displayOptionsText("3. Exit");
                    int input = intInputValidator("Enter number: ");

                    if (input == 1) {
                        MedicalRecordsConsole.updateMedicalRecord();
                    } else if (input == 2) {
                        userLogin();
                    } else if (input == 3) {
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
                displayError("Invalid email/password, please try again");
            } else {
                return user;
            }
        }
    }

    private static Map<String, String> loginForm() {

        Map<String, String> unamePassword = new HashMap<>();
        String email = null;
        while (true) {
            displayColoredMessageWithNewLine("Enter email: ", BLUE);
            email = new Scanner(System.in).nextLine();
            boolean validEmail = isValidEmail(email);
            if (!validEmail) {
                displayError("Invalid email format, please enter a valid email");
            } else {
                break;
            }
        }
        unamePassword.put("email", email);
        displayColoredMessageWithNewLine("Enter Password", BLUE);
        String pword = getScanner().nextLine();
        unamePassword.put("password", pword);

        return unamePassword;
    }
}
