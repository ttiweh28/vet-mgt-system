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
            int ownerId = ConsoleUtil.intInputValidator("Enter pet owner Id: ");

            petOwner = petOwnerService.getPetOwner(ownerId);
            if (petOwner == null) {
                ConsoleUtil.displayError("Invalid pet owner Id, couldn't find pet owner by that Id, Please try again");
            } else {
                break;
            }
        }

        ConsoleUtil.displayChoiceText("Pet owner name: " + petOwner.getFirstName() + " " + petOwner.getLastName());
        ConsoleUtil.displayChoiceText("Enter Pet Name: ");
        String petName = ConsoleUtil.getScanner().nextLine();
        int petAge = ConsoleUtil.intInputValidator("Enter Pet Age: ");

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
