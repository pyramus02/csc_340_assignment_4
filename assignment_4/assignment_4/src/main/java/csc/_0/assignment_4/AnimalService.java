package csc._0.assignment_4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;


    /**
     * Fetch all Animals
     *
     * @return the list of all Animals
     */
    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    /**
     * Fetch a unique animal.
     *
     * @param animalId the unique Animal id.
     * @return a unique animal object.
     */
    public Animal getAnimalById(int animalId) {
        return animalRepository.findById(animalId).orElse(null);
    }

    /**
     * Fetch all animals whose species matches the search term.
     *
     * @param species the search key.
     * @return the list of matching Animals.
     */
    public List<Animal> getAnimalsBySpecies(String species) {
        return animalRepository.getAnimalsBySpecies(species);
    }


    /**
     * Wildcard species search - arg of bear might return both brown bear and black bear for example
     * @param searchStr
     * @return
     */


    public List<Animal> getAnimalSearch(String searchStr) { return animalRepository.getAnimalSearch(searchStr);}

    /**
     * Add a new Animal to the database.
     *
     * @param animal the new Animal to add.
     */
    public void addNewAnimal(Animal animal) {


        animalRepository.save(animal);
    }

    /**
     * Update an existing Animal
     *
     * @param animalId the unique Animal Id.
     * @param animal  the new Animal details.
     */
    public void updateAnimal(int animalId, Animal animal) {

        Animal existing = getAnimalById(animalId);
        existing.setAnimal(animal);
        animalRepository.save(existing);
    }



    /**
     * Delete a unique animal.
     *
     * @param animalId the unique Animal Id.
     */
    public void deleteAnimalById(int animalId) {
        animalRepository.deleteById(animalId);
    }
}