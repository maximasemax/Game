package model;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface PersonConfigurationOption {
    void addPerson(Person person) throws JsonProcessingException;

}
