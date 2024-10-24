package service;

import data.Appointment;
import data.PetOwner;

import java.util.List;

public interface PetOwnerService extends UserService {

    PetOwner getPetOwner(int id);

    List<Appointment> addAppointments(PetOwner petOwner, Appointment appointment);
}

