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
    public List<Pet> getAllPets() {
        return Storage.getPets();
    }
}
