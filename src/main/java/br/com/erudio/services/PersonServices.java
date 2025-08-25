package br.com.erudio.services;

import br.com.erudio.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices { //mf=serviceImpl

    private final AtomicLong counter = new AtomicLong();// mock counter para ids

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public List<Person> findAll(){
        List<Person> persons = new ArrayList<Person>();
        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }

        return persons;
    }

    private Person mockPerson(int i) {
        logger.info("Mocking one Person");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("FirstName " + i);
        person.setLastName("LastName " + i);
        person.setAddress("Address " + i);
        person.setGender("Gender " + i);
        return person;
    }

    public Person findById(String id){
        logger.info("Finding one Person!");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Sabrina");
        person.setLastName("Jacinto Gomes");
        person.setAddress("Pluviora - Minas Gerais - Brasil");
        person.setGender("Female");
        return person;
    }

    public Person create(Person person){
        logger.info("Creating one Person!");
        return person;
    }
}
