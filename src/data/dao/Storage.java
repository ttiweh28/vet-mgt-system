package data.dao;

import data.*;

import java.util.ArrayList;
import java.util.List;

public final class Storage {

    public static List<Administrator> administrators = new ArrayList<>();
    public static List<Appointment> appointments = new ArrayList<>();
    public static List<MedicalRecord> medicalRecords = new ArrayList<>();
    public static List<Pet> pets = new ArrayList<>();
    public static List<PetOwner> petOwners = new ArrayList<>();
    public static List<VeterinaryDoctor> veterinaryDoctors = new ArrayList<>();

    private Storage() {
    }

    public static <T> void add(T item) {
        if (item instanceof Administrator) administrators.add((Administrator) item);
        else if (item instanceof Appointment) appointments.add((Appointment) item);
        else if (item instanceof MedicalRecord) medicalRecords.add((MedicalRecord) item);
        else if (item instanceof Pet) pets.add((Pet) item);
        else if (item instanceof PetOwner) petOwners.add((PetOwner) item);
        else if (item instanceof VeterinaryDoctor) veterinaryDoctors.add((VeterinaryDoctor) item);
    }

    public static List<MedicalRecord> getMedicalRecords() {
        return medicalRecords;
    }

    public static List<Appointment> getAppointments() {
        return appointments;
    }

    public static List<Pet> getPetList() {
        return pets;
    }

    //retrieve a medical record from a list of medical records using an id
    public static MedicalRecord getMedicalRecord(int recordid) {
        return medicalRecords.stream()
                .filter(record -> record.getRecordID() == recordid)
                .findFirst()
                .orElse(null);
    }

    //retrieve a particular appointment from a list of appointments using an id
    public static Appointment getAppointment(int appointmentID) {
        return appointments.stream()
                .filter(appointment -> appointment.getAppointmentID() == appointmentID)
                .findFirst()
                .orElse(null);
    }

    //retrieve a particular pet's information from a list of pets using an id
    public static Pet getPet(int petID) {
        return pets.stream()
                .filter(pet -> pet.getPetID() == petID)
                .findFirst()
                .orElse(null);
    }

}



