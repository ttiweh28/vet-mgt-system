package data;

import java.util.List;

public class PetOwner extends User {


    private List<Pet> pets;
    private List<Appointment> appointments;

    public List<Pet> getPets() {
        return pets;
    }

    public void addPet(Pet pet){
        pets.add(pet);
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}
