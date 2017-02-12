package dao;

import model.PersonEntity;

import javax.ejb.Stateless;

@Stateless
public class PersonDAO extends GenericDAO<PersonEntity> {
    PersonDAO() {super(PersonEntity.class);}
}
