package homelibrary.src.main.java.model;

import homelibrary.src.main.java.controller.SaverLoader;
import homelibrary.src.main.java.model.person.Person;

import java.io.IOException;
import java.util.ArrayList;

public class PersonContainer {

    private ArrayList<Person> people;

    public PersonContainer() {
        people = new ArrayList<>();

        try {
            people = SaverLoader.loadPeople();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Person> getPeople() {
        return people;
    }

    public Person getPerson(String login, String password) {
        for (Person person : people) {
            if (person.getLogin().equals(login)
                    && person.getPassword().equals(password)) {
                return person;
            }
        }
        return null;
    }
}
