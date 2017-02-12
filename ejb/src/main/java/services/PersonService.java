package services;

import dao.PersonDAO;
import model.PersonEntity;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class PersonService {

    @Inject
    PersonDAO personDAO;

    public List<PersonEntity> findAll() {
        return personDAO.findAll();
    }

    public void update(PersonEntity person) {
        if(person != null) {
            personDAO.update(person);
        }
    }
}
