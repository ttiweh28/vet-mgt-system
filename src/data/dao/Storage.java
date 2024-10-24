package data.dao;

import data.*;
import service.UserType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Storage.
 */
public final class Storage {

    /**
     * The constant administrators.
     */
    public static List<Administrator> administrators = new ArrayList<>();
    /**
     * The constant appointments.
     */
    public static List<Appointment> appointments = new ArrayList<>();
    /**
     * The constant medicalRecords.
     */
    public static List<MedicalRecord> medicalRecords = new ArrayList<>();
    /**
     * The constant pets.
     */
    public static List<Pet> pets = new ArrayList<>();
    /**
     * The constant petOwners.
     */
    public static List<PetOwner> petOwners = new ArrayList<>();
    /**
     * The constant veterinaryDoctors.
     */
    public static List<VeterinaryDoctor> veterinaryDoctors = new ArrayList<>();

    private Storage() {
    }

    /**
     * Add.
     *
     * @param <T>  the type parameter
     * @param item the item
     */
    public static <T> void add(T item) {
        if (item instanceof Administrator) administrators.add((Administrator) item);
        else if (item instanceof Appointment) appointments.add((Appointment) item);
        else if (item instanceof MedicalRecord) medicalRecords.add((MedicalRecord) item);
        else if (item instanceof Pet) pets.add((Pet) item);
        else if (item instanceof PetOwner) petOwners.add((PetOwner) item);
        else if (item instanceof VeterinaryDoctor) veterinaryDoctors.add((VeterinaryDoctor) item);
    }

    /**
     * Gets medical record.
     *
     * @param recordid the recordid
     * @return the medical record
     */
//retrieve a medical record from a list of medical records using an id
    public static MedicalRecord getMedicalRecord(int recordid) {
        return medicalRecords.stream()
                .filter(record -> record.getRecordID() == recordid)
                .findFirst()
                .orElse(null);
    }

    /**
     * Gets pet.
     *
     * @param petID the pet id
     * @return the pet
     */
//retrieve a particular pet's information from a list of pets using an id
    public static Pet getPet(int petID) {
        return pets.stream()
                .filter(pet -> pet.getPetID() == petID)
                .findFirst()
                .orElse(null);
    }

    /**
     * Gets pet owner.
     *
     * @param petOwnerIdD the pet owner id d
     * @return the pet owner
     */
//retrieve a particular pet's information from a list of pets using an id
    public static PetOwner getPetOwner(int petOwnerIdD) {
        return petOwners.stream()
                .filter(pet -> pet.getUserId() == petOwnerIdD)
                .findFirst()
                .orElse(null);
    }

    /**
     * Gets user by email and password.
     *
     * @param email    the email
     * @param password the password
     * @param userType the user type
     * @return the user by email and password
     */
    public static User getUserByEmailAndPassword(String email, String password, UserType userType) {

        return switch (userType) {
            case ADMINISTRATOR -> administrators.stream()
                    .filter(user -> user.getEmail().equalsIgnoreCase(email))
                    .filter(user -> user.getPassword().equals(password))
                    .findFirst()
                    .orElse(null);
            case PET_OWNER -> petOwners.stream()
                    .filter(user -> user.getEmail().equalsIgnoreCase(email))
                    .filter(user -> user.getPassword().equals(password))
                    .findFirst()
                    .orElse(null);
            case VET_DOCTOR -> veterinaryDoctors.stream()
                    .filter(user -> user.getEmail().equalsIgnoreCase(email))
                    .filter(user -> user.getPassword().equals(password))
                    .findFirst()
                    .orElse(null);
        };
    }

    /**
     * Gets appointment based on date and time.
     *
     * @param appointmentTime the appointment time
     * @return the appointment based on date and time
     */
    public static boolean getAppointmentBasedOnDateAndTime(LocalDateTime appointmentTime) {

        return appointments.stream()
                .anyMatch(appointment -> appointment.getDate().isEqual(appointmentTime)
                        && appointment.getDate().plusHours(1).isAfter(appointmentTime));
    }

    /**
     * Gets pets.
     *
     * @return the pets
     */
    public static List<Pet> getPets() {
        return pets;
    }
}



