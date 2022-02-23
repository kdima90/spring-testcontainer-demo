package kdima90.springrestdemo.rest;

import kdima90.springrestdemo.model.Person;
import kdima90.springrestdemo.service.PersonService;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;

@WebMvcTest(PersonController.class)
class PersonControllerTest {

    @MockBean
    private PersonService personService;

    @Autowired
    private MockMvc mockMvc;

    @DisplayName("Retrieve all persons")
    @Test
    void getAllPersonsShouldReturn200() throws Exception {
        Person johnDoe = new Person();
        johnDoe.setId(1L);
        johnDoe.setName("John Doe");

        Person janeDoe = new Person();
        janeDoe.setId(2L);
        janeDoe.setName("Jane Doe");

        BDDMockito.when(personService.getAllPersons()).thenReturn(Arrays.asList(johnDoe, janeDoe));
        mockMvc.perform(MockMvcRequestBuilders.get("/api/person/all"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$..id", Is.is(Arrays.asList(1, 2))))
                .andExpect(MockMvcResultMatchers.jsonPath("$..name", Is.is(Arrays.asList("John Doe", "Jane Doe"))));
    }

}