package data;

import java.time.LocalDateTime;
import java.util.Random;

public class Appointment {
    private int appointmentID;
    private LocalDateTime date;
    private String reason;
    private PetOwner petOwner;


    public Appointment(LocalDateTime time, String reason, PetOwner petOwner) {
        setAppointmentID();
        this.date = time;
        this.reason = reason;
        this.petOwner = petOwner;
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

    private void setAppointmentID() {
        this.appointmentID = new Random().nextInt(10000, 99999);
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
                ", Reason: " + reason +
                ", Pet Owner: " + (petOwner != null
                ? petOwner.getFirstName() + " " + petOwner.getLastName()
                : "No Owner Assigned");
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}

