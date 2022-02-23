package kdima90.springrestdemo.service;

import kdima90.springrestdemo.model.Person;
import kdima90.springrestdemo.repository.PersonCrudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PersonService {
    private final PersonCrudRepository personCrudRepository;

    @Transactional
    public List<Person> getAllPersons(){
        return (List<Person>) personCrudRepository.findAll();
    }
}
