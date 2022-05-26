package model;

import com.fasterxml.jackson.core.JsonProcessingException;



public interface PersonConfigurationOption {
    void addPerson(Person person) throws JsonProcessingException;

}
