package service.impl;

import data.Pet;
import data.dao.Storage;
import service.PetService;

import java.util.List;

public class PetServiceImpl implements PetService {

    @Override
    public void addPet(String name, int age) {
        Storage.add(new Pet(name, age));
    }

    @Override
    public Pet getPetById(int petId) {
        return null;
    }

    @Override
    public boolean updatePet(Pet pet) {
        return false;
    }

    @Override
    public boolean deletePet(int petId) {
        return false;
    }

    @Override
    public List<Pet> getAllPets() {
        return Storage.getPets();
    }
}
