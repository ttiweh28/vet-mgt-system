package data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pet {

    private int petID;
    private String petName;
    private int petAge;
    private List<MedicalRecord> medicalRecordList;
    private List<Appointment> appointment;

    public Pet(int petID, String petName, int petAge) {
        this.petID = petID;
        this.petName = petName;
        this.petAge = petAge;
        this.medicalRecordList = new ArrayList<>();
    }

    public Pet(int petID) {
        this.petID = petID;
    }

    public void addMedicalRecords(MedicalRecord medicalRecord) {
        medicalRecordList.add(medicalRecord);
    }

    public int getPetID() {
        return petID;
    }

    public void setPetID(int petID) {
        this.petID = petID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return petID == pet.petID && petName == pet.petName && petAge == pet.petAge;
    }

    @Override
    public int hashCode() {
        return Objects.hash(petID, petName, petAge);
    }

    @Override
    public String toString() {
        return "Pet{" +
                "petID=" + petID +
                ", petName=" + petName +
                ", petAge=" + petAge +
                '}';
    }

    public List<Appointment> getAppointment() {
        return appointment;
    }

    public List<MedicalRecord> getMedicalRecordsList() {
        return medicalRecordList;
    }

    public int getPetAge() {
        return petAge;
    }

    public String getPetName() {
        return petName;
    }

}