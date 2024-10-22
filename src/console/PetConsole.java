package console;

import data.Pet;
import data.PetOwner;
import service.impl.PetOwnerServiceImpl;

import java.util.Scanner;

public class PetConsole {

    private static final Scanner scanner = new Scanner(System.in);

    public static void addPet(PetOwner owner, PetOwnerServiceImpl service) {
        System.out.print("Enter Pet ID: ");
        int petId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Pet Name: ");
        String petName = scanner.nextLine();
        System.out.print("Enter Pet Age: ");
        int petAge = scanner.nextInt();

        Pet newPet = new Pet(petId, petName, petAge);
        owner.getPets().add(newPet);
        System.out.println("Pet added successfully.");
    }

    public static void viewPets(PetOwner owner) {
        System.out.println("Owner Pets: " + owner.getPets());
    }
}
