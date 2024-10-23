package console;

import data.MedicalRecord;
import data.Pet;
import data.PetOwner;
import service.MedicalRecordService;
import service.PetService;
import service.impl.MedicalRecordServiceImpl;
import service.impl.PetServiceImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static console.AppointmentConsole.scheduleAppointment;

public class MedicalRecordsConsole {

    public static void viewMedicalRecords() {

        ConsoleUtil.displayChoiceText("Choice pet: ");

        PetOwner owner = (PetOwner) Login.loggedInUser;

        owner.getPets()
                .stream().map(pet -> pet.getPetName())
                .reduce(1, (x, y) -> {
                    ConsoleUtil.displayOptionsText(x + ". " + y);
                    x++;
                    return x;
                }, (x, y) -> x + y);

        int input = ConsoleUtil.getScanner().nextInt();

        if (input > owner.getPets().size() || input < 0) {
            ConsoleUtil.displayError("Invalid choice");
        } else {
            ConsoleUtil.displayColoredMessageWithNewLine(owner.getPets().get(input - 1).getMedicalRecordsList().toString(), ConsoleUtil.BLUE);
        }

    }

    public static void updateMedicalRecord() {
        ConsoleUtil.displayChoiceText("Choice a pet: ");

        PetService petService = new PetServiceImpl();

        // Display all pets for the veterinarian to choose from
        petService.getAllPets().stream().map(pet -> pet.getPetName())
                .reduce(1, (x, y) -> {
                    ConsoleUtil.displayOptionsText(x + ". " + y);
                    return x + 1;
                }, Integer::sum);

        int petInput = ConsoleUtil.getScanner().nextInt();

        if (petInput > petService.getAllPets().size() || petInput <= 0) {
            ConsoleUtil.displayError("Invalid choice");
            return; // Exit if the choice is invalid
        }

        // Get the selected pet

        Pet selectedPet = petService.getAllPets().get(petInput - 1);

        // Display the medical records for the selected pet
        ConsoleUtil.displayColoredMessageWithNewLine("Choose a medical record to update using Record ID: ", ConsoleUtil.BLUE);
        selectedPet.getMedicalRecordsList().stream().map(record ->
                        "Record ID: " + record.getRecordID() + ", Treatment: " + record.getTreatment())
                .forEach(name -> ConsoleUtil.displayColoredMessageWithNewLine(name, ConsoleUtil.BLUE));

        // Find the medical record to update
        MedicalRecordService medicalRecordService = new MedicalRecordServiceImpl();

        MedicalRecord medicalRecord = null;

        while (true) {
            int recordInput = ConsoleUtil.getScanner().nextInt();
            medicalRecord = medicalRecordService.getRecordById(recordInput);

            if (medicalRecord == null) {

                ConsoleUtil.displayError("Invalid record ID, please try again ");
                ConsoleUtil.displayColoredMessage("Record Id: ", ConsoleUtil.GREEN);

            } else {
                break;
            }
        }

        // Get the new treatment or date from the veterinarian
        ConsoleUtil.displayChoiceText("Enter new treatment: ");
        String newTreatment = ConsoleUtil.getScanner().next();

        boolean updated = medicalRecordService.updateRecord(medicalRecord, newTreatment);
        if (updated) {
            ConsoleUtil.displaySuccessMessage("Medical record updated successfully!");
        } else {
            ConsoleUtil.displayError("Failed to update the medical record.");
        }

    }
}

