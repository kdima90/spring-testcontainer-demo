package kdima90.springrestdemo.rest;

import kdima90.springrestdemo.model.Person;
import kdima90.springrestdemo.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/person/")
public class PersonController {

    private final PersonService personService;

    @GetMapping("/all")
    public List<Person> getAllPersons(){
        return personService.getAllPersons();
    }
}
