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
        ConsoleUtil.displayColoredMessageWithNewLine("Choose a pet: ", ConsoleUtil.BLUE);

        PetService petService = new PetServiceImpl();

        // Display all pets for the veterinarian to choose from
        petService.getAllPets().stream().map(pet -> pet.getPetName())
                .reduce(1, (x, y) -> {
                    ConsoleUtil.displayColoredMessageWithNewLine(x + ". " + y, ConsoleUtil.BLUE);
                    return x + 1;
                }, Integer::sum);

        int petInput = ConsoleUtil.getScanner().nextInt();

        if (petInput > petService.getAllPets().size() || petInput <= 0) {
            ConsoleUtil.displayColoredMessageWithNewLine("Invalid choice", ConsoleUtil.RED);
            return; // Exit if the choice is invalid
        }

        // Get the selected pet

        Pet selectedPet = petService.getAllPets().get(petInput - 1);

        // Display the medical records for the selected pet
        ConsoleUtil.displayColoredMessageWithNewLine("Choose a medical record to update: ", ConsoleUtil.BLUE);
        selectedPet.getMedicalRecordsList().stream().map(record ->
                        "Record ID: " + record.getRecordID() + ", Treatment: " + record.getTreatment())
                .forEach(name -> ConsoleUtil.displayColoredMessageWithNewLine(name, ConsoleUtil.BLUE));

        int recordInput = ConsoleUtil.getScanner().nextInt();

        // Find the medical record to update
        MedicalRecord medicalRecordToUpdate = selectedPet.getMedicalRecordsList().stream()
                .filter(record -> record.getRecordID() == recordInput)
                .findFirst()
                .orElse(null);

        if (medicalRecordToUpdate == null) {
            ConsoleUtil.displayColoredMessageWithNewLine("Invalid record ID", ConsoleUtil.RED);
            return; // Exit if the record is not found
        }

        // Get the new treatment or date from the veterinarian
        ConsoleUtil.displayColoredMessageWithNewLine("Enter new treatment: ", ConsoleUtil.BLUE);
        String newTreatment = ConsoleUtil.getScanner().next();

        ConsoleUtil.displayColoredMessageWithNewLine("Enter new date (MM/dd/yyyy): ", ConsoleUtil.BLUE);
        String datee = ConsoleUtil.getScanner().nextLine();

        LocalDate date = ConsoleUtil.DateValidation(datee); // Parse the date input

        if (date == null) {
            scheduleAppointment();
            return;
        }
        ConsoleUtil.displayColoredMessageWithNewLine("Enter appointment time (hh:mm am/pm)", ConsoleUtil.BLUE);
        String appointmentTime = ConsoleUtil.getScanner().nextLine();

        LocalTime time = ConsoleUtil.timeValidation(appointmentTime);

        if (time == null) {
            scheduleAppointment();
            return;
        }

        LocalDateTime appointmentDate = date.atTime(time);
        // Create a new MedicalRecord object with the updated details
        MedicalRecord updatedRecord = new MedicalRecord(
                medicalRecordToUpdate.getRecordID(),
                date, // Use the new date
                newTreatment, // Use the new treatment
                medicalRecordToUpdate.getPets() // Keep the same pet
        );

        // Update the record using the service
        MedicalRecordService medicalRecordService = new MedicalRecordServiceImpl();
        boolean isUpdated = medicalRecordService.updateRecord(updatedRecord);

        if (isUpdated) {
            ConsoleUtil.displayColoredMessageWithNewLine("Medical record updated successfully!", ConsoleUtil.GREEN);
        } else {
            ConsoleUtil.displayColoredMessageWithNewLine("Failed to update the medical record.", ConsoleUtil.RED);
        }

        }
}

