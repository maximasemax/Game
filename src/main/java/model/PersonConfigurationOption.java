package model;

import com.fasterxml.jackson.core.JsonProcessingException;
import model.impl.Person;


public interface PersonConfigurationOption {
    void addPerson(Person person) throws JsonProcessingException;

}
