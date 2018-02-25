package api;

import java.util.*;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import opower.Home;
import opower.Person;

public class HomeAPI implements CommandAPI<Home> {
    private EntityManager entityManager;
    private EntityTransaction entityTransaction;
    Home home;

    public HomeAPI() {
        entityManager = LocalEntityManagerFactory.getInstance();
        entityTransaction = entityManager.getTransaction();
    }

    public Collection<Home> findAll() {
        CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
        CriteriaQuery<Home> query = criteria.createQuery(Home.class);
        Root<Home> home = query.from(Home.class);
        CriteriaQuery<Home> queryHome = query.select(home);

        return entityManager.createQuery(queryHome).getResultList();
    }

    public boolean put(Home entity) {
        if (entity != null) {
            try {
                entityTransaction.begin();
                entityManager.persist(entity);
                entityTransaction.commit();
                entityManager.close();

                return true;
            } catch (Exception e) {
                System.out.println("Exception occurred");

                return false;
            }
        } else {
            return false;
        }
    }

    public Home remove(Home identifier) {
        home = entityManager.getReference(Home.class, identifier);

        if (home != null) {
            entityTransaction.begin();
            entityManager.remove(home);
            entityTransaction.commit();
            entityManager.close();
        }

        return home;
    }

    public Home update(Home entity) {
        if (entity != null) {
            entityTransaction.begin();
            entityManager.merge(entity);
            entityTransaction.commit();
            entityManager.close();
        }

        return entity;
    }

    public Home get(Object identifier) {
        if (identifier == null) {
            throw new IllegalArgumentException("The argument cannot be null");
        } else {
            home = (Home) (entityManager.find(Home.class, identifier));
        }

        return home;
    }
}