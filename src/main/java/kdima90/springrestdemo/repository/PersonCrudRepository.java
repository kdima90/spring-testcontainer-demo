package kdima90.springrestdemo.repository;

import kdima90.springrestdemo.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonCrudRepository extends CrudRepository<Person, Long> {
}
