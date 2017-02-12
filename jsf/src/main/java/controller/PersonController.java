package controller;

import mapper.PersonMapper;
import model.PersonEntity;
import model.PersonJSF;
import org.primefaces.context.PrimeFacesContext;
import org.primefaces.event.SelectEvent;
import services.PersonService;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.util.List;

@ManagedBean(name = "personController")
@SessionScoped
public class PersonController {

    @Inject
    PersonService personService;

    @Inject
    PersonMapper personMapper;

    private List<PersonJSF> persons;
    private PersonJSF selectedPerson = new PersonJSF();

    @PostConstruct
    public void init() {
        persons = personMapper.fromDatabaseModel(personService.findAll());
    }

    public List<PersonJSF> getPersons() {
        return persons;
    }

    public void setPersons(List<PersonJSF> persons) {
        this.persons = persons;
    }

    public PersonJSF getSelectedPerson() {
        return selectedPerson;
    }

    public void setSelectedPerson(PersonJSF selectedPerson) {
        this.selectedPerson = selectedPerson;
    }

    public void doClick() {
        if(selectedPerson != null) {
            PersonEntity dbPerson = personMapper.toDatabaseModel(selectedPerson);
            personService.update(dbPerson);

            PrimeFacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "OK", "The person with id: " + selectedPerson.getId() + " was successful updated!"));
        } else {
            PrimeFacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "OK", "No field selected!"));
        }
    }
}
