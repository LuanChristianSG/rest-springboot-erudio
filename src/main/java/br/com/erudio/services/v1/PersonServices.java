package br.com.erudio.services.v1;

import br.com.erudio.data.dto.v1.PersonDTO;
import br.com.erudio.exception.ResourceNotFoundException;
import static br.com.erudio.mapper.ObjectMapper.parseObject;
import static br.com.erudio.mapper.ObjectMapper.parseListObjects;
import br.com.erudio.model.Person;
import br.com.erudio.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;



@Service("v1.PersonServices")
public class PersonServices { //mf=serviceImpl

    private final AtomicLong counter = new AtomicLong();// mock counter para ids
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;



    public List<PersonDTO> findAll(){
        logger.info("Finding all People!");

        return parseListObjects(repository.findAll(), PersonDTO.class); //ObjectMapper.class
    }

    private PersonDTO mockPerson(int i) {
        logger.info("Mocking one Person");

        PersonDTO person = new PersonDTO();
        person.setId(counter.incrementAndGet());
        person.setFirstName("FirstName " + i);
        person.setLastName("LastName " + i);
        person.setAddress("Address " + i);
        person.setGender("Gender " + i);
        return person;
    }

    public PersonDTO findById(Long id){
        logger.info("Finding one Person!");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID")); //porque repository.findById nao retorna um Person e sim um Optional do tipo Person
        return parseObject(entity, PersonDTO.class);

    }

    public PersonDTO create(PersonDTO person){
        logger.info("Creating one Person!");
        var entity = parseObject(person, Person.class);

        return parseObject(repository.save(entity), PersonDTO.class);
    }

    public PersonDTO update(PersonDTO person){
        logger.info("Creating one Person!");

        Person entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return parseObject(repository.save(entity), PersonDTO.class);
    }

    public void delete(Long id){
        logger.info("Deleting one Person!");

        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        repository.delete(entity);
    }
}
