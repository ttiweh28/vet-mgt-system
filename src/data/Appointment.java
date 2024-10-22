package data;

import java.time.LocalDate;

public class Appointment {
    private int appointmentID;
    private LocalDate date;
    private LocalDate time;
    private String reason;
    private PetOwner petOwner;


    public Appointment(int appointmentID, LocalDate date, LocalDate time, String reason) {
        this.appointmentID = appointmentID;
        this.date = date;
        this.time = time;
        this.reason = reason;
    }

    public PetOwner getPetOwner() {
        return petOwner;
    }

    public void setPetOwner(PetOwner petOwner) {
        this.petOwner = petOwner;
    }

    public int getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(int appointmentID) {
        this.appointmentID = appointmentID;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "Appointment ID: " + appointmentID +
                ", Date: " + date +
                ", Time: " + time +
                ", Reason: " + reason +
                ", Pet Owner: " + (petOwner != null
                ? petOwner.getFirstName() + " " + petOwner.getLastName()
                : "No Owner Assigned");
    }

}

