package model.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import model.PersonConfigurationOption;

import java.util.ArrayList;
import java.util.List;

public class PersonConfiguration implements PersonConfigurationOption {

    private String name;
    private List<Person> persons;

    public PersonConfiguration(String name) {
        this.name = name;
        this.persons = new ArrayList<>();
    }

    public PersonConfiguration() {
    }

    public List<Person> getPersons() {
        return persons;
    }

    @Override
    public String toString() {
        return "PersoneConfiguration{"
                + "name='"
                + name
                + '\''
                + ", persons="
                + persons
                + '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public void addPerson(Person person) throws JsonProcessingException {
        persons.add(person);
    }
}
