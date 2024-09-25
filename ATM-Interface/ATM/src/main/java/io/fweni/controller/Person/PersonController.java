package io.fweni.controller.Person;

import com.google.common.collect.ImmutableList;
import io.fweni.app.db.memory.MemoryDb;
import io.fweni.app.model.Person;

import java.util.Optional;

public class PersonController {

    public Optional<Person> getBanker(Person person) {
        return MemoryDb.INSTANCE.findPerson(person.getEmail());
    }
    public Person addNewBanker(Person person) {
        return MemoryDb.INSTANCE.addPerson(person);
    }
    public ImmutableList<Person> getAllBankers() {
        return MemoryDb.INSTANCE.allPersons();
    }
}
