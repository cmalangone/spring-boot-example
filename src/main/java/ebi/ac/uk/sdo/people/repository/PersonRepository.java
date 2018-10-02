package ebi.ac.uk.sdo.people.repository;

import ebi.ac.uk.sdo.people.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findById(Long id);

    List<Person> findByFirstName(String firstName);

    List<Person> findByLastName(String lastName);

    Person findByFirstNameAndLastNameAndAge(String firstName, String lastName, Integer age);

    Person findByFirstNameAndLastNameAndAgeAndFavouriteColour(String firstName, String lastName, Integer age, String favouriteColour);

}