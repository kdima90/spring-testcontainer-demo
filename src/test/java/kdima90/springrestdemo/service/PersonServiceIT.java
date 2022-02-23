package kdima90.springrestdemo.service;

import kdima90.springrestdemo.model.Person;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("testcontainer")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
class PersonServiceIT {

    @Autowired
    private TestEntityManager testEntityManager;

    @DisplayName("Two users should be in database")
    @Test
    void verifyUsersAreExisting() {
        Person john = testEntityManager.find(Person.class, 1L);
        Assertions.assertThat(john).isNotNull();
        Assertions.assertThat(john.getName()).isEqualTo("John Doe");

        Person jane = testEntityManager.find(Person.class, 2L);
        Assertions.assertThat(jane).isNotNull();
        Assertions.assertThat(jane.getName()).isEqualTo("Jane Doe");
    }

}