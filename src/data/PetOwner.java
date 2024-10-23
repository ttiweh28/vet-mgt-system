package data;

import java.util.ArrayList;
import java.util.List;

public class PetOwner extends User {


    private List<Pet> pets = new ArrayList<>();
    private List<Appointment> appointments = new ArrayList<>();

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public void addPet(Pet pet) {
        pets.add(pet);
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}
