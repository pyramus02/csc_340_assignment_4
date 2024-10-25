package csc._0.assignment_4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import java.util.List;

@Controller
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
    private AnimalService service;

    /**
     * Get a list of all Animals in the database.
     * http://localhost:8080/animals/all
     *
     * @return a list of Animals objects.
     */
    @GetMapping("/all")
    public String getAllAnimals(Model model) {
        model.addAttribute("animalList", service.getAllAnimals());
        return "animal-list";
    }

    /**
     * Get a specific Animal by Id.
     * http://localhost:8080/animals/2
     *
     * @param animalId the unique Id for an Animal.
     * @return One Animal object.
     */
    @GetMapping("/{animalId}")
    public String getOneAnimal(@PathVariable int animalId, Model model) {
        model.addAttribute("animal", service.getAnimalById(animalId));
        return "animal-details";
    }

    /**
     * Get a list of Animals based on their species.
     *
     * @param speciesStr the search key.
     * @return A list of Animal objects matching the search key.
     */
    @GetMapping("/species")
    public String getSpecies(String speciesStr, Model model) {
        model.addAttribute("animalList", service.getAnimalsBySpecies(speciesStr));
        return "animal-list";
    }
    /**
     * Wildcard name search
     *
     * http://localhost:8080/animals/name?name=bear
     *
     * would return both black bear and polar bear.
     *
     * @param searchStr
     * @return
     */
    @GetMapping("/name")
    public String getAnimalsByName(String searchStr, Model model) {
        model.addAttribute("animalList", service.getAnimalSearch(searchStr));
        return "animal-list";
    }

    /**
     * Method for displaying the front end for animal creation
     *
     * @return
     */
    @GetMapping("/new")
    public String formNewAnimal(Model model) {
        Animal newAnimal = new Animal();
        model.addAttribute("animal", newAnimal);
        return "animal-create";
    }

    /**
     * Create a new Animal entry.
     * http://localhost:8080/animals/new
     *
     * @param animal the new Animal object.
     * @return the updated list of Animal.
     */
    @PostMapping("/novelty")
    public String addNewAnimal(Animal animal, Model model) {
        service.addNewAnimal(animal);
        return "redirect:/animals/all";
    }

    @GetMapping("/update/{animalId}")
    public String changeAnimal(@PathVariable int animalId, Model model) {
        model.addAttribute("animal", service.getAnimalById(animalId));
        return "animal-update";
    }

    /**
     * Update an existing animal object.
     *
     * @param animal unique Animal Id.
     * @return the updated Animal object.
     */


    @PostMapping("/mutate")
    String updateAnimal(Animal animal) {

        service.updateAnimal(animal.getAnimalId(), animal);
        return "redirect:/animals/" + animal.getAnimalId();
    }

    /**
     * Delete a Animal object.
     *
     * @param animalId the unique Student Id.
     * @return the updated list of Students.
     */
    @GetMapping("/delete/{animalId}")
    public String deleteAnimalById(@PathVariable int animalId) {
        service.deleteAnimalById(animalId);
        return "redirect:/animals/all";
    }
}