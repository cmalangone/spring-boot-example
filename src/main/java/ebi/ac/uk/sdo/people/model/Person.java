package ebi.ac.uk.sdo.people.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;
import javax.persistence.Entity;

@Entity
@Table(name="PEOPLE")
@SequenceGenerator(name="people", sequenceName = "person_seq", allocationSize=1)
public class Person {

    // The colour can be an Enum or a table in the db.
    //enum Colour{
    //    BLUE, YELLOW, RED, GREEN, WHITE, BLACK;
    //}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    private Integer age;

    @JsonProperty("favourite_colour")
    private String favouriteColour;


    // No-args constructor
    public Person() {
    }

    // Constructor with params
    public Person(String firstName,
                  String lastName,
                  Integer age,
                  String favouriteColour) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.favouriteColour = favouriteColour;
    }


    // Getter and Setter

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getFavouriteColour() {
        return favouriteColour;
    }

    public void setFavouriteColour(String favouriteColour) {
        this.favouriteColour = favouriteColour;
    }
}
