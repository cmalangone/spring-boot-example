package ebi.ac.uk.sdo.people.controller;

import ebi.ac.uk.sdo.people.model.Person;
import ebi.ac.uk.sdo.people.repository.PersonRepository;
import ebi.ac.uk.sdo.people.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class PersonRestController {

    private PersonService personService;

    @Autowired
    PersonRestController(PersonService personService) {
        this.personService = personService;
    }


    /**
     * <p>Retrieve all the people</p>
     * @return list of people using JSON format
     */
    @RequestMapping("/people")
    List<Person> all() {
        return personService.findAll();
    }


    /**
     * <p>Find a person by id </p>
     * @param id : unique identifier of the person
     * @return the person using JSON format or 404 not found
     */
    @GetMapping("/person/{id}")
    Person one(@PathVariable Long id) {
        return personService.find(id);
    }

    /**
     * <p>Add people to the db (POST) </p>
     * @param people: list of people using json format
     * @return 200 and JSON message
     */
    @RequestMapping(value = "/addpeople", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<String> addPeople(@RequestBody Map<String, ArrayList<Person>> people) {
        HttpHeaders responseHeaders = setResponseHttpHeaders();

        if (people.get("person") != null) {
            for (Person newPerson: people.get("person")) {
                if (personService.addPerson(newPerson)) {
                    // you can count or return the list of added people
                    System.out.println("Added a new person");
                }
            }
        }
        return new ResponseEntity<>(returnJSONMessage(),responseHeaders, HttpStatus.OK);
    }

    /**
     * <p>Update people using PUT </p>
     * @param people: list of people using json format
     * @return 200 and JSON message
     */
    @RequestMapping(value = "/updatepeople", method = RequestMethod.PUT)
    public @ResponseBody
    ResponseEntity<String> update(@RequestBody Map<String, ArrayList<Person>>  people) {
        HttpHeaders responseHeaders = setResponseHttpHeaders();

        if (people.get("person") != null) {
            for (Person person: people.get("person")) {
                if(personService.updatePerson(person)){
                    // you can count or return the list of updated people
                    System.out.println("Updated person".concat(person.getId().toString()));
                };
            }
        }

        return new ResponseEntity<>(returnJSONMessage(),responseHeaders, HttpStatus.OK);
    }

    /**
     * <p>Delete people using DELETE request </p>
     * @param people: list of people using json format
     * @return 200 and JSON message
     */
    @RequestMapping(value = "/deletepeople", method = RequestMethod.DELETE)
    public @ResponseBody
    ResponseEntity<String> delete(@RequestBody Map<String, ArrayList<Person>>  people) {
        HttpHeaders responseHeaders = setResponseHttpHeaders();

        if (people.get("person") != null) {
            for (Person deletePerson: people.get("person")) {
                if(personService.deletePerson(deletePerson)){
                    // you can store and return ids deleted.
                    System.out.println("Deleted person");
                };
            }
        }

        return new ResponseEntity<>(returnJSONMessage(),responseHeaders, HttpStatus.OK);
    }


    // DRY: this function is called in many place of this class.
    private HttpHeaders setResponseHttpHeaders(){
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Content-Type", "application/json; charset=utf-8");
        return responseHeaders;
    }

    // DRY: this function is called in many place of this class.
    // Return a JSON string "message":"ok"
    private String returnJSONMessage() {
        String  result= new StringBuilder("{\"message\":\"ok").append("\"}").toString();
        return result;
    }

}


