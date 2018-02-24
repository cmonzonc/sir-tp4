package api;

import java.util.*;

import javax.persistence.*;
import javax.persistence.criteria.*;

import opower.Person;

public class PersonAPI implements CommandAPI<Person> {
    
	private EntityManager entityManager;
    private EntityTransaction entityTransaction;
    Person person;

    public PersonAPI() {
        entityManager = LocalEntityManagerFactory.getInstance();
        entityTransaction = entityManager.getTransaction();
    }


    public Collection<Person> findAll() {
        CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
        CriteriaQuery<Person> query = criteria.createQuery(Person.class);
        Root<Person> pers = query.from(Person.class);
        CriteriaQuery<Person> q = query.select(pers);

        return entityManager.createQuery(q).getResultList();
    }

    public Person update(Person entity) {
        if (entity != null) {
        		entityTransaction.begin();
            entityManager.merge(entity);
            entityTransaction.commit();
        }

        return entity;
    }

	public Person get(Object identifier) {
 System.out.println(identifier);
		  return (Person)(entityManager.find(Person.class, identifier));
		
	}

	public void put(Person entity) {
        if (entity != null) {
            ;
        }
        
        {
            entityTransaction.begin();
            entityManager.persist(entity);
            entityTransaction.commit();
        }
		
	}

	public Person remove(Person identifier) {
		
        person = entityManager.getReference(Person.class, identifier);

        if (person != null) {
            entityTransaction.begin();
            entityManager.remove(person);
            entityTransaction.commit();
        }

        return person;
	}
    
}