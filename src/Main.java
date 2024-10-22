import console.ConsoleUtil;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        ConsoleUtil.displayColoredMessage("Load DummyData?", ConsoleUtil.BLUE);


        while (true) {
            System.out.println("\n1. Admin Login");
            System.out.println("2. Pet Owner Login");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    //    AdministratorConsole.adminMenu();
                    break;
                case 2:
                    //  PetOwnerConsole.petOwnerMenu();
                    break;
                case 3:
                    System.out.println("Exiting the system.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
