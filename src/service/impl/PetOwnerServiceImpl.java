package service.impl;

import data.Appointment;
import data.PetOwner;
import data.dao.Storage;
import service.PetOwnerService;

import java.util.List;

public class PetOwnerServiceImpl extends UserServiceImpl implements PetOwnerService {

    @Override
    public PetOwner getPetOwner(int id) {
        return Storage.getPetOwner(id);
    }

    @Override
    public List<Appointment> addAppointments(PetOwner petOwner, Appointment appointment) {
        petOwner.getAppointments().add(appointment);
        return petOwner.getAppointments();
    }
}
