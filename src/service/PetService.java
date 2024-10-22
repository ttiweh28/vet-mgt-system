package service;

import data.Pet;

import java.util.List;

public interface PetService {
    void addPet(String name, int age);

    Pet getPetById(int petId);

    boolean updatePet(Pet pet);

    boolean deletePet(int petId);

    List<Pet> getAllPets();
}