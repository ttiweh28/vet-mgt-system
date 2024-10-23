package service;

import data.Appointment;
import data.Pet;
import data.PetOwner;

import java.util.List;

public interface PetOwnerService extends UserService {

    void addPetOwner(PetOwner petOwner);

    PetOwner getPetOwner(int id);

    List<Pet> getPets(PetOwner owner);

    List<Appointment> getAppointments(PetOwner owner);

    List<Appointment> addAppointments(PetOwner petOwner, Appointment appointment);
}

