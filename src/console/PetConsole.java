package console;

import data.Pet;
import data.PetOwner;
import service.PetOwnerService;
import service.PetService;
import service.impl.PetOwnerServiceImpl;
import service.impl.PetServiceImpl;

import java.util.Scanner;

/**
 * The type Pet console.
 */
public class PetConsole {

    private static final Scanner scanner = new Scanner(System.in);


    public static void addPet() {

        PetOwnerService petOwnerService = new PetOwnerServiceImpl();

        PetOwner petOwner = null;

        while (true) {
            ConsoleUtil.displayColoredMessage("Enter Owner Id: ", ConsoleUtil.BLUE);
            int ownerId = ConsoleUtil.getScanner().nextInt();

            petOwner = petOwnerService.getPetOwner(ownerId);
            if (petOwner == null) {
                ConsoleUtil.displayError("Invalid Owner Id, couldn't find Owner by that Id, Please try again");
            } else {
                break;
            }
        }

        ConsoleUtil.displayColoredMessage("Enter Pet Name: ", ConsoleUtil.BLUE);
        String petName = ConsoleUtil.getScanner().nextLine();
        ConsoleUtil.displayColoredMessage("Enter Pet Age: ", ConsoleUtil.BLUE);
        int petAge = scanner.nextInt();

        PetService petService = new PetServiceImpl();
        petService.addPet(petName, petAge);

        Pet newPet = new Pet(petName, petAge);
        petOwner.getPets().add(newPet);

       ConsoleUtil.displaySuccessMessage("Pet added successfully.");
    }

    /**
     * View pets.
     *
     * @param owner the owner
     */
    public static void viewPets(PetOwner owner) {
        System.out.println("Owner Pets: " + owner.getPets());
    }


}
