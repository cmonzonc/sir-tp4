package services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;

import opower.ElectronicDevice;
import opower.Heater;
import opower.Home;
import opower.Person;

public class GeneralQueries {
    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
    protected EntityManager manager = factory.createEntityManager();
    CriteriaBuilder cb = manager.getCriteriaBuilder();
    
    public GeneralQueries(EntityManager manager) {
        this.manager = manager;
        this.cb = cb;
    }

}