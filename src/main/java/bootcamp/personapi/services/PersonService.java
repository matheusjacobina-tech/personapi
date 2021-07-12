package bootcamp.personapi.services;

import lombok.AllArgsConstructor;
import bootcamp.personapi.entities.Person;
import bootcamp.personapi.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {

    private PersonRepository personRepository;

    public Person create(Person person) {
        return personRepository.save(person);
    }
}
