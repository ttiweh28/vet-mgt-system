package service;

import data.PetOwner;
import data.Pet;
import data.Appointment;
import java.util.List;

public interface PetOwnerService extends UserService {
    List<Pet> getPets(PetOwner owner);
    List<Appointment> getAppointments(PetOwner owner);
}
