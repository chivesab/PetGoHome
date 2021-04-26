package team10spring2021cmpe272.petgohome.Dao;

import team10spring2021cmpe272.petgohome.Backend.Pet;

public interface PetDao {
    public int save(Pet pet);

    public void update(Pet pet);

    public void deletePetByPetId(long petId);

    public void searchPetByPetId(long petId);
}
