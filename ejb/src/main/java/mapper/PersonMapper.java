package mapper;

import model.PersonJSF;
import model.PersonEntity;
import util.DateUtil;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class PersonMapper {
    public List<PersonEntity> toDatabaseModel(List<PersonJSF> persons) {
        List<PersonEntity> dbPersons = new ArrayList<PersonEntity>();
        for(PersonJSF person : persons) {
            dbPersons.add(toDatabaseModel(person));
        }
        return dbPersons;
    }

    public PersonEntity toDatabaseModel(PersonJSF person) {
        PersonEntity dbPerson = new PersonEntity();

        dbPerson.setId(person.getId());
        dbPerson.setName(person.getName());
        dbPerson.setSurname(person.getSurname());
        dbPerson.setEmail(person.getEmail());
        dbPerson.setGender(person.getGender());
        dbPerson.setBirthDay(person.getBirthDay());
        dbPerson.setAddress(person.getAddress());
        dbPerson.setActive(person.getActive());

        return dbPerson;
    }

    public List<PersonJSF> fromDatabaseModel(List<PersonEntity> dbPersons) {
        List<PersonJSF> persons = new ArrayList<PersonJSF>();
        for(PersonEntity dbPerson : dbPersons) {
            persons.add(fromDatabaseModel(dbPerson));
        }
        return persons;
    }

    public PersonJSF fromDatabaseModel(PersonEntity dbPerson) {
        PersonJSF person = new PersonJSF();

        person.setId(dbPerson.getId());
        person.setName(dbPerson.getName());
        person.setSurname(dbPerson.getSurname());
        person.setEmail(dbPerson.getEmail());
        person.setGender(dbPerson.getGender());
        person.setBirthDay(dbPerson.getBirthDay());
        person.setAddress(dbPerson.getAddress());
        person.setActive(dbPerson.getActive());

        return person;
    }

    public PersonEntity fromTo(PersonEntity from, PersonEntity to) {
        to.setId(from.getId());
        to.setName(from.getName());
        to.setSurname(from.getSurname());
        to.setEmail(from.getEmail());
        to.setGender(from.getGender());
        to.setBirthDay(from.getBirthDay());
        to.setAddress(from.getAddress());
        to.setActive(from.getActive());

        return to;
    }
}
