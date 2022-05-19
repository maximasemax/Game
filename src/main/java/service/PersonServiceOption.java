package service;

import model.Person;

import java.io.IOException;
import java.util.List;

public interface PersonServiceOption {

    void showAllPerson() throws IOException;

    List<Person> getPersons() throws IOException;
    Person chosePerson() throws IOException;

}
