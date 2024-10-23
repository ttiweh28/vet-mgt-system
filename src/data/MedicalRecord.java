package data;

import java.time.LocalDate;

public class MedicalRecord {

    private int recordID;
    private LocalDate date;
    private String treatment;
    private Pet pet;


    public MedicalRecord(int recordID, LocalDate date, String treatment, Pet pet) {
        this.recordID = recordID;
        this.date = date;
        this.treatment = treatment;
        this.pet = pet;
    }

    public MedicalRecord(int recordID) {
        this.recordID = recordID;
    }

    public int getRecordID() {
        return recordID;
    }

    public void setRecordID(int recordID) {
        this.recordID = recordID;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public Pet getPets() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    @Override
    public String toString() {
        return "MedicalRecords:\n" +
                "recordID : " + recordID +
                "\ndate : " + date +
                "\ntreatment :" + treatment + '\n';
    }
}
