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



}
