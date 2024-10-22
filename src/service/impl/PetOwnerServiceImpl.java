package service.impl;

import data.Appointment;
import data.Pet;
import data.PetOwner;
import data.dao.Storage;
import service.PetOwnerService;

import java.util.List;

public class PetOwnerServiceImpl extends UserServiceImpl implements PetOwnerService {

    @Override
    public void addPetOwner(PetOwner petOwner) {

    }

    @Override
    public PetOwner getPetOwner(int id) {
        return Storage.getPetOwner(id);
    }

    @Override
    public List<Pet> getPets(PetOwner owner) {
        return null;//owner.getPets();
    }

    @Override
    public List<Appointment> getAppointments(PetOwner owner) {
        return null;
    }
}
