package service;

import data.Pet;

public interface PetService {
    Pet createPet(Pet pet);

    Pet getPetById(int petId);

    boolean updatePet(Pet pet);

    boolean deletePet(int petId);
}