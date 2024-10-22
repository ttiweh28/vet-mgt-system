package service;

import data.Appointment;
import data.Pet;
import data.PetOwner;

import java.util.List;

public interface PetOwnerService extends UserService {
    List<Pet> getPets(PetOwner owner);

    List<Appointment> getAppointments(PetOwner owner);
}
