package data.dao;

import data.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class Store {

    public static List<Administrator> administrators= new ArrayList<>();
    public static List<Appointment> appointments= new ArrayList<>();
    public static List<MedicalRecords> medicalRecords= new ArrayList<>();
    public static List<Pet> pets= new ArrayList<>();
    public static List<PetOwner> petOwners= new ArrayList<>();
    public static List<VeterinaryDoctor> veterinaryDoctors= new ArrayList<>();

    private Store() {
    }

    public static <T> void add(T item){
        if ( item instanceof Administrator) administrators.add((Administrator) item);
        else if ( item instanceof Appointment) appointments.add((Appointment) item);
        else if ( item instanceof MedicalRecords) medicalRecords.add((MedicalRecords) item);
        else if ( item instanceof Pet) pets.add((Pet) item);
        else if ( item instanceof PetOwner) petOwners.add((PetOwner) item);
        else if ( item instanceof VeterinaryDoctor) veterinaryDoctors.add((VeterinaryDoctor) item);
        }

    public static List<MedicalRecords> getMedicalRecords() {
        return medicalRecords;
    }
    public static List<Appointment> getAppointments() {
        return appointments;
    }

    public static List<Pet> getPetList() {
        return pets;
    }

    //retrieve a medical record from a list of medical records using an id
    public static String getMedicalRecord(int recordid){
            return medicalRecords.stream()
                    .filter(record -> record.getRecordID() == recordid)
                    .findFirst()
                    .map(record -> "Medical Record ID: " + record.getRecordID() +
                            ", Date: " + record.getDate() +
                            ", Treatment: " + record.getTreatment() +
                            ", Pet: " + record.getPets().getPetName())
                    .orElse("Medical record not found");
        }

    //retrieve a particular appointment from a list of appointments using an id
    public static String getAppointment(int appointmentID){
        return appointments.stream()
                .filter(appointment -> appointment.getAppointmentID() == appointmentID)
                .findFirst()
                .map(appointment -> "Appointment: " + appointment.getAppointmentID() +
                        ", Date: " + appointment.getDate() +
                        ", Time: " + appointment.getTime() +
                        ", Reason: " + appointment.getReason() +
                        ", for : " + (appointment.getPetOwner() != null ? appointment.getPetOwner().getLastName()+" "+appointment.getPetOwner().getFirstName() : "No Owner Assigned"))
        .orElse("Appointment not found");
    }
    //retrieve a particular pet's information from a list of pets using an id
    public static String getPet(int petID){
        return pets.stream()
                .filter(pet -> pet.getPetID() == petID)
                .findFirst()
                .map(pet -> "Pet: " + pet.getPetID() +
                        ", Name: " + pet.getPetName() +
                        ", Age: " + pet.getPetAge() )
                .orElse("Pet not found");
    }

    }



