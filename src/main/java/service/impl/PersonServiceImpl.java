package service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import model.impl.Person;
import model.impl.PersonConfigurationImpl;
import service.PersonServiceOption;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class PersonServiceImpl implements PersonServiceOption {

    Scanner scanner = new Scanner(System.in);


    @Override
    public void showAllPerson() throws IOException {
        List<Person> personList = new ArrayList<>(getPersons());

        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
        for (Person person : personList) {
            count += 1;
            stringBuilder.append(count + ". Name: " + person.getName());
            stringBuilder.append("\n");
            stringBuilder.append("Attack skill: " + person.getAttackSkill());
            stringBuilder.append("\n");
            stringBuilder.append("Defence skill: " + person.getDefenceSkill());
            stringBuilder.append("\n");
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
    }

    @Override
    public List<Person> getPersons() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        PersonConfigurationImpl personConfiguration = objectMapper.readValue(new File("src\\main\\resources\\persons.yml"), PersonConfigurationImpl.class);
        return personConfiguration.getPersons();
    }

    @Override
    public Person chosePerson() throws IOException {
        showAllPerson();
        System.out.println("Please chose person and write name.");
        int numberOfPerson = scanner.nextInt();
        List<Person> personList = new ArrayList<>(getPersons());
        System.out.println("Person selected!\n");
        return personList.get(numberOfPerson - 1);

    }

    @Override
    public Person chosePersonBot() throws IOException {
        Random random = new Random();
        System.out.println("Bots chose!");
        return getPersons().get(random.nextInt(getPersons().size()));
    }

}
