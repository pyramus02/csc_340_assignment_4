package csc._0.assignment_4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
    private AnimalService service;

    /**
     * Get a list of all Animals in the database.
     * http://localhost:8080/animals/all
     *
     * @return a list of Animals  objects.
     */
    @GetMapping("/all")
    public List<Animal> getAllAnimals() {
        return service.getAllAnimals();
    }

    /**
     * Get a specific Animal by Id.
     * http://localhost:8080/animals/2
     *
     * @param animalId the unique Id for an Animal.
     * @return One Animal object.
     */
    @GetMapping("/{animalId}")
    public Animal getOneAnimal(@PathVariable int animalId) {
        return service.getAnimalById(animalId);
    }

    /**
     * Get a list of Animals based on their species.

     *
     * @param species the search key.
     * @return A list of Animal objects matching the search key.
     */
    @GetMapping("")
    public List<Animal> getAnimalsBySpecies(@RequestParam(name = "species", defaultValue = "gray wolf") String species) {
        return service.getAnimalsBySpecies(species);
    }


    /**
     *
     *
     * Wildcard species search
     *
     * http://localhost:8080/animals/find?find=bear
     *
     * would return both black bear and polar bear.
     *
     * @param searchStr
     * @return
     */

    @GetMapping("/find")
    public List<Animal> getAnimalsSearch(@RequestParam(name = "find", defaultValue = "gray wolf") String searchStr) {
        return service.getAnimalSearch(searchStr);
    }



    /**
     * Create a new Animal entry.
     * http://localhost:8080/animals/new --data '{"name":"Luna","scientificName":"Canis lupus","species":"Gray Wolf","habitat":"Forest","description":"Very playful young female"}'
     *
     * @param animal the new Animal object.
     * @return the updated list of Animal.
     */
    @PostMapping("/new")
    public @ResponseBody List<Animal> addNewAnimal(@RequestBody Animal animal) {
        service.addNewAnimal(animal);
        return service.getAllAnimals();
    }


    /**
     * Update an existing animal object.
     
     *
     * @param animalId the unique Animal Id.
     * @param animal the new update Animal details.
     * @return the updated Animal object.
     */
    @PutMapping("/update/{animalId}")
    public Animal updateAnimal(@PathVariable int animalId, @RequestBody Animal animal) {
        service.updateAnimal(animalId, animal);
        return service.getAnimalById(animalId);
    }

    /**
     * Delete a Animal object.
     *
     * @param animalId the unique Student Id.
     * @return the updated list of Students.
     */
    @DeleteMapping("/delete/{animalId}")
    public List<Animal> deleteAnimalById(@PathVariable int animalId) {

        service.deleteAnimalById(animalId);
        return service.getAllAnimals();
    }
}
