package csc._0.assignment_4;
import jakarta.persistence.*;

@Entity
@Table(name = "animals")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int animalId;

    @Column(nullable = false)
    public String name;

    @Column(nullable = true)
    private String scientificName;

    @Column(nullable = false)
    private String species;

    @Column(nullable = false)
    private String habitat;

    @Column(nullable = true)
    private String description;


    public Animal(String name, String scientificName, String species, String habitat, String description)
    {
        this.name = name;
        this.scientificName = scientificName;
        this.species = species;
        this.habitat = habitat;
        this.description = description;
    }

    public Animal() {}

    public int getAnimalId() {
        return this.animalId;
    }

    public void setAnimalId(int animalId) {this.animalId = animalId;}

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScientificName() {
        return this.scientificName;
    }

    public void setScientificName(String scientificName) {this.scientificName = scientificName;}

    public String getSpecies() {
        return this.species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getHabitat() {
        return this.habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {this.description = description;}

    public void setAnimal(Animal newAnimal)
    {
        this.name = newAnimal.getName();
        this.scientificName = newAnimal.getScientificName();
        this.species = newAnimal.getSpecies();
        this.habitat = newAnimal.getHabitat();
        this.description = newAnimal.getDescription();
    }
}

