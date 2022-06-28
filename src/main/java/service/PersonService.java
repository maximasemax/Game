package service;

import model.impl.Person;

import java.io.IOException;
import java.util.List;

public interface PersonService {

    void showAllPerson() throws IOException;

    List<Person> getPersons() throws IOException;

    Person chosePerson() throws IOException;

    Person chosePersonBot() throws IOException;


}
