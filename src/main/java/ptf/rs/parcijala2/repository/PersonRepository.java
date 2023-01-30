package ptf.rs.parcijala2.repository;

import ptf.rs.parcijala2.models.Person;

import java.util.List;

public interface PersonRepository {
    void addPerson(Person person);
    List<Person> getAll();
}
