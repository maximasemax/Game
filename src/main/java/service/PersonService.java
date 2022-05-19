package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import model.Person;
import model.PersonConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class PersonService implements PersonServiceOption {

    Scanner scanner = new Scanner(System.in);



    @Override
    public void showAllPerson() throws IOException {
        System.out.println(getPersons());
    }

    @Override
    public List<Person> getPersons() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        PersonConfiguration personConfiguration = objectMapper.readValue(new File("src\\\\\\\\main\\\\\\\\resources\\\\\\\\persons.yml"), PersonConfiguration.class);
        return personConfiguration.getPersons();
    }

    @Override
    public Person chosePerson() throws IOException {
        showAllPerson();
        System.out.println("Please chose person and write name.");
        String nameOfPerson = scanner.nextLine().toLowerCase(Locale.ROOT);
        List<Person> personList = getPersons();
        for (Person person : personList) {
            if (person.getName().toLowerCase(Locale.ROOT).equals(nameOfPerson)) {
                System.out.println("Персонаж выбран!");
                return person;
            }
        }
        System.out.println("Такого персонажа нету(");
        return null;
    }


}
