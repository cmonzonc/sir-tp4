package services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import opower.Person;

public class PersonServices extends GeneralQueries {
	
    CriteriaQuery<Person> criteriaQuery = cb.createQuery(Person.class);
    Root<Person> personRoot = criteriaQuery.from(Person.class);

    public PersonServices(EntityManager manager) {
        super(manager);
    }

    public void showResponse(List<Person> persons) {
        for (Person person : persons) {
            System.out.println(">:" + person.getName());
            System.out.println(">:" + person.getSurname());
        }
    }

    public List<Person> getPersonByIdentifier(int identifier) {
        criteriaQuery.select(personRoot);
        criteriaQuery.where(cb.equal(personRoot.get("id"), identifier));

        List<Person> persons = manager.createQuery(criteriaQuery).getResultList();

        showResponse(persons);

        return persons;
    }

    public List<Person> getPersonByName(String name) {
        criteriaQuery.select(personRoot);
        criteriaQuery.where(cb.equal(personRoot.get("name"), name));

        List<Person> persons = manager.createQuery(criteriaQuery).getResultList();

        showResponse(persons);

        return persons;
    }

    public List<Person> getPersonBySurname(String surname) {
        criteriaQuery.select(personRoot);
        criteriaQuery.where(cb.equal(personRoot.get("surname"), surname));

        List<Person> persons = manager.createQuery(criteriaQuery).getResultList();

        showResponse(persons);

        return persons;
    }

    public List<Person> getPersons() {
        CriteriaQuery<Person> all = criteriaQuery.select(personRoot);
        TypedQuery<Person> allQuery = manager.createQuery(all);
        List<Person> persons = allQuery.getResultList();

        showResponse(persons);

        return persons;
    }
}