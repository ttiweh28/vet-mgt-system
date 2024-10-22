package service.impl;

import data.Appointment;
import data.Pet;
import data.PetOwner;
import service.PetOwnerService;

import java.util.List;

public class PetOwnerServiceImpl extends UserServiceImpl implements PetOwnerService {

    @Override
    public List<Pet> getPets(PetOwner owner) {
        return null;//owner.getPets();
    }

    @Override
    public List<Appointment> getAppointments(PetOwner owner) {
        return null;
    }
}
