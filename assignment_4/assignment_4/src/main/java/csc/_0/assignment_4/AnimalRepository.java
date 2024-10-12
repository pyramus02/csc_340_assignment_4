package csc._0.assignment_4;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {

    List<Animal> getAnimalsBySpecies(String species);


    @Query(value = "SELECT * FROM animals WHERE species LIKE %?%;", nativeQuery = true)
    List<Animal> getAnimalSearch(String searchStr);

    @Query(value = "DELETE FROM animals WHERE animal_id = ?;", nativeQuery = true)
    void deleteAnimalById(int animalId);






}
