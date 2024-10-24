package service;

import data.Pet;

import java.util.List;

public interface PetService {
    void addPet(String name, int age);

    List<Pet> getAllPets();
}