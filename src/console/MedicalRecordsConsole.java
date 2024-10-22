package console;

import data.PetOwner;
import service.PetService;
import service.impl.PetServiceImpl;

public class MedicalRecordsConsole {

    public static void viewMedicalRecords() {

        ConsoleUtil.displayColoredMessageWithNewLine("Choice pet: ", ConsoleUtil.BLUE);

        PetOwner owner = (PetOwner) Login.loggedInUser;

        owner.getPets()
                .stream().map(pet -> pet.getPetName())
                .reduce(1, (x, y) -> {
                    ConsoleUtil.displayColoredMessageWithNewLine(x + ". " + y, ConsoleUtil.BLUE);
                    x++;
                    return x;
                }, (x, y) -> x + y);

        while (true) {

            int input = ConsoleUtil.getScanner().nextInt();

            if (input > owner.getPets().size() || input < 0) {
                ConsoleUtil.displayColoredMessageWithNewLine("Invalid choice", ConsoleUtil.RED);
            } else {
                ConsoleUtil.displayColoredMessageWithNewLine(owner.getPets().get(input - 1).getMedicalRecordsList().toString(), ConsoleUtil.BLUE);
            }

        }

    }

    public static void updateMedicalRecord() {
        ConsoleUtil.displayColoredMessageWithNewLine("Choice pet: ", ConsoleUtil.BLUE);

        PetService petService = new PetServiceImpl();

        petService.getAllPets().stream().map(pet -> pet.getPetName())
                .reduce(1, (x, y) -> {
                    ConsoleUtil.displayColoredMessageWithNewLine(x + ". " + y, ConsoleUtil.BLUE);
                    x++;
                    return x;
                }, (x, y) -> x + y);

        int input = ConsoleUtil.getScanner().nextInt();

        if (input > petService.getAllPets().size() || input < 0) {
            ConsoleUtil.displayColoredMessageWithNewLine("Invalid choice", ConsoleUtil.RED);
        } else {

        }
    }
}
