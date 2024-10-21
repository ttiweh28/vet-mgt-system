package data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pet {

    private int petID;
    private int petName;
    private int petAge;
    private List<MedicalRecords> medicalRecordsList;
    private Appointment appointment;

    public Pet(int petID, int petName, int petAge, int recordID) {
        this.petID = petID;
        this.petName = petName;
        this.petAge = petAge;
        this.medicalRecordsList = new ArrayList<>();
    }

    public Pet(int petID, int petName, int petAge, List<MedicalRecords> medicalRecordsList, Appointment appointment) {
        this.petID = petID;
        this.petName = petName;
        this.petAge = petAge;
        this.medicalRecordsList = medicalRecordsList;
        this.appointment = appointment;
    }

    public void addMedicalRecords(MedicalRecords medicalRecords){
        medicalRecordsList.add(medicalRecords);
    }

    public Pet(int petID) {
        this.petID = petID;
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

    public Appointment getAppointment() {
        return appointment;
    }

    public List<MedicalRecords> getMedicalRecordsList() {
        return medicalRecordsList;
    }

    public int getPetAge() {
        return petAge;
    }

    public int getPetName() {
        return petName;
    }
}
