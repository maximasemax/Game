package service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import model.impl.Person;

import java.io.IOException;

public class FileService {


    public Person getPerson(String name) throws IOException {
        return null;
    }

    public Person parsePerson(String fileName) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        return objectMapper.readValue("src/main/resources/" + fileName, Person.class);
    }


}

